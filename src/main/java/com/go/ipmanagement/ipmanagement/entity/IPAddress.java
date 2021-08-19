package com.go.ipmanagement.ipmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name ="ip_address")
public class IPAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4042201199427103839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@EqualsAndHashCode.Exclude
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private IPPool ipPool;

	private String ipValue;

}
