package com.naver.utill;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NvMovie {
	
	public static void movie() throws IOException {

		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		System.out.println("Title : 네이버 영화 크롤링한거");

		// CSS 선택자를 사용해 링크 추출하기
//		Elements menus = doc.select("#scrollbar ul li a");
		Elements menus = doc.select("#old_content > table > tbody > tr:nth-child(2) > td.title > div > a");
//		#old_content > table > tbody > tr:nth-child(2) > td.title > div > a
//		#old_content > table > tbody > tr:nth-child(3) > td.title > div > a
//		#old_content > table > tbody > tr:nth-child(4) > td.title > div > a
//		#old_content > table > tbody > tr:nth-child(11) > td.title > div > a
		
		//위 링크에 각각 접속해서 이미지 주소 가져오기
		

		// 반복문 적용하기
		for (Element menu : menus) {

			// 링크의 "title" 속성 값 추출하기
			String title = menu.attr("title").trim();

			// 링크의 URL 추출하기 (절대경로)
			String nextUrl = menu.absUrl("href");

			// log
			System.out.println(String.format("%s\n\t%s", title, nextUrl));

			// 링크 대상 페이지에 접근하기
//			Document nextDoc = Jsoup.connect(nextUrl).get();

			// 상세 내용 추출하기
//			String content = nextDoc.select("div.mw-parser-output").html();

		}
	}
}