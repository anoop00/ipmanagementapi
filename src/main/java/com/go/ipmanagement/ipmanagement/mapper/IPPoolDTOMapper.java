package com.go.ipmanagement.ipmanagement.mapper;


import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPPool;

public class IPPoolDTOMapper {
	
	public static IPPoolDTO getIPPoolDTO(IPPool ipPool) {
		
		IPPoolDTO ipPoolDTO = new IPPoolDTO();
		ipPoolDTO.setIpPool(ipPool);
		ipPoolDTO.setIpAddress(ipPool.getIpAddresses());
		
		return ipPoolDTO;
	}

}
