package com.asif.fun.htmlparser.parser;

import com.asif.fun.htmlparser.model.Indices;
import com.asif.fun.htmlparser.model.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mhussaa on 4/21/17.
 */
public class HTMLParser {

    public void parse(String html) {

        boolean startTag = false;
        for(int i = 0; i<html.length(); ++i) {
            if(html.charAt(i) == ' ') {
                continue;
            }

            if(html.charAt(i) == '<') {
                if(i+1 < html.length() && html.charAt(i+1) == '/') {
                    // Ignore </hr> </br> such tags & this could be end of opened tag
                    String tagName = getWord(i+2, html);
                    i += tagName.length() + 1;

                    if(startTag) {
                        startTag = false;
                    }

                    continue;
                }

                Tag tag = getTag(i+1, html);
                startTag = true;
                System.out.println(tag);
                i += tag.getIndices().getEndIndex();
            } else {
                // get the body of the tag
                StringBuilder body = new StringBuilder();
                for(int j=i; j<html.length(); ++j) {
                    if(html.charAt(j) == '<') {
                        break;
                    } else {
                        body.append(html.charAt(j));
                    }
                }
                System.out.println("body: " + body);
                i += body.length();
            }
        }
    }

    private Tag getTag(int startIndex, String content) {
        Tag tag = new Tag();
        String tagName = getWord(startIndex, content);
        tag.setTagName(tagName);

        Indices indices = new Indices();
        indices.setStartIndex(startIndex-1);

        for(int i = startIndex+tagName.length()+1; i < content.length(); ++i) {
            if(content.charAt(i) == ' ') {
                continue;
            } else if(content.charAt(i) == '/') {
                if(i+1 < content.length() && content.charAt(i+1) == '>') {
                    // it is unpaired tag
                    tag.setPairedTag(false);
                    indices.setEndIndex(i+1);
                    break;
                }
            } else if(content.charAt(i) == '>') {
                tag.setPairedTag(true);
                indices.setEndIndex(i);
                break;
            }

            String attributeName = getAttributeName(i, content);
            i += attributeName.length();
            String attributeValue = "";
            if(content.charAt(i) == '=') {
                attributeValue = getAttributeValue(i+1, content);
                i += attributeValue.length();
                if(attributeValue.charAt(0) == '"' || attributeValue.charAt(0) == '\'') {
                    attributeValue = attributeValue.substring(1, attributeValue.length()-1);
                }
            }
            // System.out.println("attributeName: " + attributeName);
            // System.out.println("attributeValue: " + attributeValue);
            tag.addAttributes(attributeName, attributeValue);
        }

        tag.setIndices(indices);

        return tag;
    }

    private String getWord(int startIndex, String text) {
        StringBuilder word = new StringBuilder();
        for(int i = startIndex; i<text.length(); ++i) {
            if(text.charAt(i) == ' ' || text.charAt(i) == '>') {
                break;
            } else {
                word.append(text.charAt(i));
            }
        }

        return word.toString();
    }

    private String getAttributeName(int startIndex, String text) {
        StringBuilder word = new StringBuilder();
        for(int i = startIndex; i<text.length(); ++i) {
            if(text.charAt(i) == ' ' || text.charAt(i) == '>' || text.charAt(i) == '=' || text.charAt(i) == '/') {
                break;
            } else {
                word.append(text.charAt(i));
            }
        }

        return word.toString();
    }

    private String getAttributeValue(int startIndex, String text) {
        StringBuilder word = new StringBuilder();
        boolean isQuoted = false;
        if(text.charAt(startIndex) == '"') {
            // For now assuming attributes' values are double-quoted
            isQuoted = true;
        }

        word.append(text.charAt(startIndex));
        for(int i = startIndex+1; i<text.length(); ++i) {
            if(text.charAt(i) == '>') {
                break;
            } else if(text.charAt(i) == ' ' && !isQuoted) {
                break;
            } else if(text.charAt(i) == '"' && isQuoted) {
                word.append(text.charAt(i));
                break;
            } else {
                word.append(text.charAt(i));
            }
        }

        return word.toString();
    }
}
