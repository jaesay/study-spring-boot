package com.sb;

import java.util.Arrays;

import javax.jdo.annotations.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.sb.persistence.FreeBoardReplyRepository;
import com.sb.persistence.FreeBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class FreeBoardTests {

	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	@Transactional
	@Test
	public void TestFreeBoard() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.getPage(page).forEach(arr ->
				log.info(Arrays.toString(arr))
		);
		/*boardRepo.findByBnoGreaterThan(0L, page).forEach(board -> {
			log.info(board.getBno() + ": " + board.getTitle() + ":" + board.getReplies().size());
		});*/
		/*FreeBoard board = new FreeBoard();
		board.setBno(199L);
		
		FreeBoardReply reply = new FreeBoardReply();
		reply.setReply("REPLY..................");
		reply.setReplier("replier00");
		reply.setBoard(board);
		
		replyRepo.save(reply);*/
		
		/*Optional<FreeBoard> result = boardRepo.findById(199L);
		
		result.ifPresent(board -> {
			List<FreeBoardReply> replies = board.getReplies();
			FreeBoardReply reply = new FreeBoardReply();
			reply.setReply("REPLY................");
			reply.setReplier("replier00");
			reply.setBoard(board);
			
			replies.add(reply);
			
			board.setReplies(replies);
			
			boardRepo.save(board);
		});*/
	}
	
	/*@Test 
	public void insertDummy() {
		IntStream.range(1, 200).forEach(i -> {
			FreeBoard board = new FreeBoard();
			board.setTitle("Free Board ... " + i);
			board.setContent("Free Content ....... " + i);
			board.setWriter("user" + i%10);
			
			boardRepo.save(board);
		});
	}*/
	
}
