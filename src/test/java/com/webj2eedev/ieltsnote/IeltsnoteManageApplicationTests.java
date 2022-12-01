package com.webj2eedev.ieltsnote;

import lombok.Builder;
import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
@Data
@Builder
class PhoneticSymbol{
	private String word;
	private String british;
	private String american;
}
@SpringBootTest
class IeltsnoteManageApplicationTests {

	@Test
	void downloadWordAudioFromYoudao() throws IOException {
		String url = "https://dict.youdao.com/dictvoice?audio=chronic&type=1";

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url).get().build();
		Response response = client.newCall(request).execute();
		byte[] audioBytes = response.body().bytes();
		FileOutputStream fos = new FileOutputStream("chronic.mp3");
		fos.write(audioBytes);
		fos.close();
		response.close();
	}



	@Test
	void getPhoneticSymbolFromYoudao() throws IOException {

		String url = "https://www.youdao.com/result?word=big&lang=en";

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url).get().build();
		Response response = client.newCall(request).execute();
		String html = response.body().string();
		response.close();


		PhoneticSymbol.PhoneticSymbolBuilder builder = PhoneticSymbol.builder();
		builder.word("big");

		Document doc = Jsoup.parse(html);
		Elements links = doc.select("div.per-phone");
		for (Element link : links) {
			if("英".equalsIgnoreCase(link.selectFirst("span").text())){
				builder.british(link.selectFirst("span.phonetic").text());
			}else if("美".equalsIgnoreCase(link.selectFirst("span").text())){
				builder.american(link.selectFirst("span.phonetic").text());
			}
		}

		System.out.println(builder.build().toString());
	}




}
