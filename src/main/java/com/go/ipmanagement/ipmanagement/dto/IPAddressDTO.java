package com.go.ipmanagement.ipmanagement.dto;

import java.util.List;

import com.go.ipmanagement.ipmanagement.entity.IPAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPAddressDTO {
	
	private int poolId;
	private List<IPAddress> ipAddresses;

}
