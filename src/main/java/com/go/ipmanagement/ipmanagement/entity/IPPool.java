package com.go.ipmanagement.ipmanagement.entity;



import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	
	@OneToMany(mappedBy = "ipPool", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<IPAddress> ipAddresses = new TreeSet<>();

}
