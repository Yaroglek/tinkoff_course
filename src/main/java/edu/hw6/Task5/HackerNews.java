package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    public long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://hacker-news.firebaseio.com/v0/topstories.json"))
            .build();
        try {
            String result = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            String[] numbers = result.replaceAll("[\\[\\]]", "").split(",");
            return Arrays.stream(numbers).mapToLong(Long::parseLong).toArray();
        } catch (IOException | InterruptedException ex) {
            return new long[] {};
        }

    }

    public String news(long id) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
            .build();
        try {
            String result = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            Matcher matcher = Pattern.compile("\"title\":\"(.*)\",\"type\"").matcher(result);
            return matcher.find() ? matcher.group(1) : "";

        } catch (IOException | InterruptedException ex) {
            return "";
        }
    }
}
