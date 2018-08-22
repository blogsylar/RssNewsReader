package ru.macdroid.newsreader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RssObject {


    private String status;
    private Feed feed;
    private List<Item> items = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Feed getFeed() {
        return feed;
    }
    public void setFeed(Feed feed) {
        this.feed = feed;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}