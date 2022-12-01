package com.webj2eedev.ieltsnote.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WordUtil {
    public static byte[] downloadWordAudio(String word, String type) throws IOException {
        String url = "https://dict.youdao.com/dictvoice?audio=" + word + "&type=" + type;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).get().build();
        Response response = client.newCall(request).execute();
        byte[] audioBytes = response.body().bytes();
        response.close();
        return audioBytes;
    }

    public static String[] downloadWordPhoneticSymbol(String word) throws IOException {
        String url = "https://www.youdao.com/result?word="+word+"&lang=en";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).get().build();
        Response response = client.newCall(request).execute();
        String html = response.body().string();
        response.close();

        String british = null;
        String american = null;

        Document doc = Jsoup.parse(html);
        Elements links = doc.select("div.per-phone");
        for (Element link : links) {
            if("英".equalsIgnoreCase(link.selectFirst("span").text())){
                british = link.selectFirst("span.phonetic").text();
            }else if("美".equalsIgnoreCase(link.selectFirst("span").text())){
                american = link.selectFirst("span.phonetic").text();
            }
        }

        return new String[]{british, american};
    }
}