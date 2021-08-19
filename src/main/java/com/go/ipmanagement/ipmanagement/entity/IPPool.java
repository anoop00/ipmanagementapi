package com.go.ipmanagement.ipmanagement.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ip_pool")
public class IPPool implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7467712120720710652L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private int totalCapacity;
	private int usedCapacity;
	private String lowerBound;
	private String upperBound;
	
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "ipPool", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<IPAddress> ipAddresses;

}
