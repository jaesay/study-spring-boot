package com.sb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="ssb_member")
@EqualsAndHashCode(of="uid")
public class Member {

	@Id
	private String uid;
	private String upw;
	private String uname;
	
}
