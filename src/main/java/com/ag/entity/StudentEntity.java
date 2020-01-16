package com.ag.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This class contain persitable data
 * @author AVNISH SINGH
 *@version 2.2
 */
@Data
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue
	private Integer sid;
	private String name;
	private String addrs;
	private Long mobNo;
	private String email;
	private String status;
	private String pazzword;

}
