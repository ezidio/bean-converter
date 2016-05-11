package br.com.tavares.el.converter.tweeter.complete;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Everton Tavares on 08/05/2016.
 */
public class Entities {

    private static final long serialVersionUID = 1L;

    private List<UrlEntity> urls = new LinkedList<UrlEntity>();

    private List<HashTagEntity> tags = new LinkedList<HashTagEntity>();

    public List<UrlEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlEntity> urls) {
        this.urls = urls;
    }

    public List<HashTagEntity> getTags() {
        return tags;
    }

    public void setTags(List<HashTagEntity> tags) {
        this.tags = tags;
    }
}
