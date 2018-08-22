package ru.macdroid.newsreader;

import java.util.HashMap;
import java.util.Map;

public class Enclosure {

    private String link;
    private String type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}