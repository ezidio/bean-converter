package br.com.tavares.el.converter.tweeter.simplified;

import br.com.tavares.el.converter.annotation.ConvertFrom;
import br.com.tavares.el.converter.annotation.PropertyMapping;
import br.com.tavares.el.converter.tweeter.complete.Tweet;

import java.util.List;

/**
 * Classe simplificada para o Tweet
 */
@ConvertFrom(Tweet.class)
public class SimpleTweet {

    @PropertyMapping("origin.id")
    private String code;

    @PropertyMapping("origin.user.name += ' (@' += origin.user.screenName += ')'")
    private String user;

    @PropertyMapping("origin.text")
    private String text;

    @PropertyMapping("origin.entities.urls.stream().findFirst().orElse(null).url")
    private String url;

    @PropertyMapping("origin.entities.tags.stream().map(h -> h.text).toList()")
    private List<String> tags;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
