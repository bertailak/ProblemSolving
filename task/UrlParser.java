package task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class UrlParser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();

        List<String> list = getUrlParams(url);

        for (String l : list) {
            System.out.println(l);
        }

        sc.close();
    }

    public static List<String> getUrlParams(String url) {
        List<String> result = new ArrayList<>();
        String[] mainParts = url.split("\\?");

        getMainPart(mainParts[0], result);
        if (mainParts.length > 1)
            getSecondPart(mainParts[1], result);

        return result;
    }

    private static void getMainPart(String url, List<String> list) {

        String proto = "http";
        String host = "";
        String handle = "";

        if (url.startsWith("https")) {
            proto = "https";
        }

        url = url.replace(proto + "://", "");

        int domainIndex = url.indexOf("/");
        if (domainIndex >= 0) {
            host = url.substring(0, domainIndex);
            handle = url.substring(domainIndex + 1);
            if (handle.endsWith("/")) {
                handle = url.substring(domainIndex + 1, url.length() - 1);
            }
        } else {
            host = url;
        }

        list.add("Proto: " + proto);
        list.add("Host: " + host);
        if (handle.length() > 0) {
            list.add("Handle: " + handle);
        }
    }

    private static void getSecondPart(String url, List<String> list) {
        String[] params = url.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            list.add(p[0] + " -> " + p[1]);
        }
    }

    @Test
    public void test1() {
        assertEquals(
                List.of("Proto: https", "Host: tyndex.com", "Handle: api/search", "text -> funny+cats", "page -> 1"),
                getUrlParams("https://tyndex.com/api/search?text=funny+cats&page=1"));
    }

    @Test
    public void test2() {
        assertEquals(
                List.of("Proto: http", "Host: tyndex.com:5000", "Handle: api/search", "text -> funny+cats"),
                getUrlParams("http://tyndex.com:5000/api/search/?text=funny+cats"));
    }

    @Test
    public void test3() {
        assertEquals(
                List.of("Proto: https", "Host: www.youtube.com", "Handle: watch", "v -> dQw4w9WgXcQ"),
                getUrlParams("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }

    @Test
    public void test4() {
        assertEquals(
                List.of("Proto: http", "Host: example.com"),
                getUrlParams("http://example.com"));
    }

    @Test
    public void test5() {
        assertEquals(
                List.of("Proto: http", "Host: example.com"),
                getUrlParams("http://example.com/"));
    }
}
