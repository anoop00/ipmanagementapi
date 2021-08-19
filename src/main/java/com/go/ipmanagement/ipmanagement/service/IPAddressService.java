package com.go.ipmanagement.ipmanagement.service;

import java.util.List;

import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;


public interface IPAddressService {

	List<IPPoolDTO> generateIPAdress(int ipAmount, int poolId);
}
