package com.go.ipmanagement.ipmanagement.mapper;

import com.go.ipmanagement.ipmanagement.dto.IPAddressDTO;
import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPPool;

// Instead of this Mapper we can use library to convert entity into DTO

public class IPManagerDTOMapper {

	public static IPPoolDTO getIPPoolDTO(IPPool ipPool) {

		IPPoolDTO ipPoolDTO = new IPPoolDTO();
		ipPoolDTO.setIpPool(ipPool);
		ipPoolDTO.setIpAddress(ipPool.getIpAddresses());

		return ipPoolDTO;
	}

	public static IPAddressDTO getAddressDTO(IPPool pool) {
		IPAddressDTO ipAddressDTO = new IPAddressDTO();
		ipAddressDTO.setPoolId(pool.getId());
		ipAddressDTO.setIpAddresses(pool.getIpAddresses());
		return ipAddressDTO;
	}

}
