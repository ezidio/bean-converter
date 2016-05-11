package br.com.tavares.el.converter;

import br.com.tavares.el.converter.tweeter.simplified.SimpleTweet;
import br.com.tavares.el.converter.tweeter.complete.Tweet;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Everton Tavares on 30/03/2016.
 */
public class SimpleBeanConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void should_convert_tweet() throws Exception {

        Tweet tweet = TestUtils.loadObject("/tweet.json", Tweet.class);

        SimpleTweet result = new BeanConverter().convert(tweet, SimpleTweet.class);

        assertEquals(tweet.getText(), result.getText());
        assertEquals(Lists.newArrayList("Ruby", "TheDevConf"), result.getTags());
        assertEquals("https://t.co/L2PKu17aD6", result.getUrl());
        assertEquals("TDC2016 (@TheDevConf)", result.getUser());

    }


}