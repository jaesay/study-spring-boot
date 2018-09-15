package com.sb.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sb.domain.MemberVO;

@Controller
public class SampleController {

	//layout
	@GetMapping("/sample/hello")
	public void hello() {
		
	}
	
	@GetMapping("/sample1")
	public void sample1(Model model) {
		model.addAttribute("greeting", "안녕하세요");
	}
	
	@GetMapping("/sample2")
	public void sample2(Model model) {
		MemberVO vo = new MemberVO(123, "u00", "p00", "홍길동", new Timestamp(System.currentTimeMillis()));
		
		model.addAttribute("vo", vo);		
	}
	
	@GetMapping("/sample3")
	public void sample3(Model model) {
		List<MemberVO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(new MemberVO(123, "u0" + i, "p0" + i, "홍길동" + i, new Timestamp(System.currentTimeMillis())));
		}
		
		model.addAttribute("list", list);
	}
	
	//지역변수 선언, if~unless
	@GetMapping("/sample4")
	public void sample4(Model model) {
		List<MemberVO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(new MemberVO(i, "u000" + i%3, "p0000" + i%3, "홍길동" + i, new Timestamp(System.currentTimeMillis())));
		}
		
		model.addAttribute("list", list);
	}
	
	//inline style, javascript
	@GetMapping("/sample5")
	public void sample5(Model model) {
		String result = "SUCCESS";
		
		model.addAttribute("result", result);
	}
	
	//inline style, text
	@GetMapping("/sample6")
	public void sample6(Model model) {
		List<MemberVO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(new MemberVO(123, "u0" + i, "p0" + i, "홍길동" + i, new Timestamp(System.currentTimeMillis())));
		}
		
		model.addAttribute("list", list);
		
		String result = "SUCCESS";
		
		model.addAttribute("result", result);
	}
	
	//Thymeleaf의 유틸리티 객체
	@GetMapping("/sample7")
	public void sample7(Model model) {
		model.addAttribute("now", new Date());
		model.addAttribute("price", 123456789);
		model.addAttribute("title", "This is a just sample");
		model.addAttribute("options", Arrays.asList("AAAA", "BBB", "CCC", "DDD"));
	}
	
	//Thymeleaf Link 처리
	@GetMapping("/sample8")
	public void sample8(Model model) {
		
	}
}
