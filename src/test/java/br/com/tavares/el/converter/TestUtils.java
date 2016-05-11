package br.com.tavares.el.converter;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utilidades para teste
 */
public class TestUtils {

    public static <T> T loadObject(String file, Class<T> type) throws IOException {
        InputStream tweetSrc = TestUtils.class.getResourceAsStream(file);
        String tweetContent = CharStreams.toString(new InputStreamReader(tweetSrc, Charsets.UTF_8));
        return new Gson().fromJson(tweetContent, type);
    }
}
