package com.sb;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.sb.domain.Board;
import com.sb.domain.QBoard;
import com.sb.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository repo;
	
	@Test
	public void testJPA() {
		String type = "t";
		String keyword = "17";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard board = QBoard.board;
		
		if(type.equals("t")) {
			builder.and(board.title.like("%" + keyword + "%"));
		}
		
		builder.and(board.bno.gt(0L));
		
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Board> result = repo.findAll(builder, pageable);
		
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());
		
		List<Board> list = result.getContent();
		
		list.forEach(b -> System.out.println(b));
		
		/*repo.findByTitle2("17")
			.forEach(arr -> System.out.println(Arrays.toString(arr)));*/
		
		/*repo.findByTitle("17")
			.forEach(board -> System.out.println(board));*/
		/*Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");
		
		Page<Board> result = repo.findByBnoGreaterThan(0L, paging);
		
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());
		
		List<Board> list = result.getContent();
		
		list.forEach(board -> System.out.println(board));*/
		
		//Collection<Board> results = repo.findByWriterContaining("05");
		
		
		/*repo.findBoardByTitle("제목200")
		.forEach(board->System.out.println(board));*/
		
		//Collection<Board> results = repo.findByWriter("user00");
		
		//results.forEach(board->System.out.println(board));
	}
	
	/*@Test
	public void testInsert200() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("제목" + i);
			board.setContent("내용....." + i + "채우기");
			board.setWriter("user0" + (i%10));
			repo.save(board);
		}
	}*/
	
	
	/*@Test
	public void testDelete() {
		System.out.println("DELETE Entity");
		
		boardRepo.deleteById(1L);
	}
	*/
	
	/*
	@Test
	public void testUpdate() {
		System.out.println("Read First........................");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("Update Title......................");
		board.setTitle("수정된 제목");
		
		System.out.println("Call Save().......................");
		boardRepo.save(board);
	}
	*/
	/*
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("게시물 제목");
		board.setContent("게시물 내용");
		board.setWriter("user00");
		
		boardRepo.save(board);
	}
	*/
	
	/*
	@Test
	public void testRead() {
		Board board = boardRepo.findById(1L).get();
		
		System.out.println(board);
	}
	*/
	
}
