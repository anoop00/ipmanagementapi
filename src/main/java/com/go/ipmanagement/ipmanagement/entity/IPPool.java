package com.go.ipmanagement.ipmanagement.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ip_pool")
public class IPPool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private int totalCapacity;
	private int usedCapacity;
	private String lowerBound;
	private String upperBound;
	//private Set<IPAddress> ipAddresses;

}
