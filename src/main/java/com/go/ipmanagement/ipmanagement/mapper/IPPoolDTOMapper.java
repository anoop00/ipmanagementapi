package com.go.ipmanagement.ipmanagement.mapper;

import java.util.List;

import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;

public class IPPoolDTOMapper {
	
	public static IPPoolDTO getIPPoolDTO(IPPool ipPool, List<IPAddress> ipAddresses) {
		
		IPPoolDTO ipPoolDTO = new IPPoolDTO();
		ipPoolDTO.setIpPool(ipPool);
		ipPoolDTO.setIpAddress(ipAddresses);
		
		return ipPoolDTO;
	}

}
