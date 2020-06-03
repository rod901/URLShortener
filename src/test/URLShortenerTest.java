package test;

import main.URLShortener;
import org.junit.jupiter.api.Assertions;

class URLShortenerTest {
    String uri = "https://www.t-mobile.com/cell-phone/samsung-galaxy-note10-plus-5g?sku=610214662927";
    String local = "http://localhost/";

    @org.junit.jupiter.api.Test
    void getShort() {
        String expected = URLShortener.getShort(uri);
        Assertions.assertNotEquals(expected, uri);
    }

    @org.junit.jupiter.api.Test
    void testForDuplicates() {
        String actual = URLShortener.getShort(uri);
        String expected = URLShortener.getShort(uri);
        Assertions.assertNotEquals("http://localhost/cell-phone-1", actual);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getHitCounter() {
        int expected = 1;
        int actual = URLShortener.getHitCounter(uri);
        Assertions.assertEquals(expected, actual);
    }
}