package com.sb.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sb.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
