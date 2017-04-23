package com.asif.fun.htmlparser.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mhussaa on 4/22/17.
 */
public class Tag {
    private String tagName;
    private Map<String, String> attributes = new HashMap<String, String>();
    private boolean isPairedTag;
    private Indices indices;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public void addAttributes(String attributeName, String attributeValue) {
        this.attributes.put(attributeName, attributeValue);
    }

    public boolean isPairedTag() {
        return isPairedTag;
    }

    public void setPairedTag(boolean pairedTag) {
        this.isPairedTag = pairedTag;
    }

    public Indices getIndices() {
        return indices;
    }

    public void setIndices(Indices indices) {
        this.indices = indices;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", attributes=" + attributes +
                ", isPairedTag=" + isPairedTag +
                ", indices=" + indices +
                '}';
    }
}
