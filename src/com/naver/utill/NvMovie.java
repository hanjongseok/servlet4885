package com.naver.utill;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.dto.MovieDTO;

public class NvMovie {

	public static ArrayList<MovieDTO> movie() throws IOException {
		// Dto 를 전달 하는 리스트
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		System.out.println("Title : 네이버 영화 크롤링");


		// CSS 선택자를 사용해 링크 추출하기
		for (int i = 2; i < 12; i++) {
//		Elements menus = doc.select("#scrollbar ul li a");
			Elements menus = doc.select("#old_content > table > tbody > tr:nth-child("+i+") > td.title > div > a");
//			Elements img = doc.select("img");

			// 위 링크에 각각 접속해서 이미지 주소 가져오기
//		#content > div.article > div.mv_info_area > div.poster > a
			// 위 선택자를 doc.select() 에 넣어서 이미지 주소 가져오기 (menu.absUrl("src"))
			//
//
//		Document doc1 = Jsoup.connect("url주소").get();
//        String folder = doc1.title();
//        Element element = doc1.select("#flick0 > li.item2 > div.obj_off.tab4 > a > img").get(0);
//        Elements img = element.select("img");
//        int page = 0;
//        for (Element e : img) {
//            String url1 = e.getElementsByAttribute("src").attr("src");
//            
//            URL imgUrl = new URL(url1);
//            BufferedImage jpg = ImageIO.read(imgUrl);
//            File file = new File("경로"+folder+"\\"+page+".jpg");
//            ImageIO.write(jpg, "jpg", file);
//            page+=1;

//		// 반복문 적용하기
			for (Element menu : menus) {
//
//			// 링크의 "title" 속성 값 추출하기
				String title = menu.attr("title").trim();
//
//			// 링크의 URL 추출하기 (절대경로)
				String nextUrl = menu.absUrl("href");

//			// log
				System.out.println(String.format("%s\n\t%s", title, nextUrl));

				// 링크 대상 페이지에 접근하기
				Document nextDoc = Jsoup.connect(nextUrl).get();

				// 상세 내용 추출하기
				String content = nextDoc.select("#content > div.article > div.mv_info_area > div.poster > a > img").attr("src");
				System.out.println(content);
		
				
				MovieDTO dto = new  MovieDTO();
				
				dto.setTitle(title);
				dto.setLink(nextUrl);
				dto.setImg(content);
				
				list.add(dto);
				
			}
		}
		return list;
	}

}