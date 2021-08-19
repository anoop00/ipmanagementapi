package com.go.ipmanagement.ipmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class IPAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//private IPPool ipPool;

	private String ipValue;

}
