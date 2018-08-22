package ru.macdroid.newsreader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {

  
    private String title;
    private String pubDate;
    private String link;
    private String guid;
    private String author;
    private String thumbnail;
    private String description;
    private String content;
    private Enclosure enclosure;

    public Item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, Enclosure enclosure, List<Object> categories, Map<String, Object> additionalProperties) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.enclosure = enclosure;
        this.categories = categories;
        this.additionalProperties = additionalProperties;
    }

    private List<Object> categories = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Enclosure getEnclosure() {
        return enclosure;
    }
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
    public List<Object> getCategories() {
        return categories;
    }
    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}