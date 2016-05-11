package br.com.tavares.el.converter.tweeter.complete;

/**
 * Created by Everton Tavares on 08/05/2016.
 */
public class HashTagEntity {

    private String text;

    private int[] indices;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
