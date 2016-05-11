package br.com.tavares.el.converter.tweeter.complete;

/**
 * Created by Everton Tavares on 08/05/2016.
 */
public class UrlEntity {


    private static final long serialVersionUID = 1L;

    private String display;

    private String expanded;

    private String url;

    private int[] indices;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
