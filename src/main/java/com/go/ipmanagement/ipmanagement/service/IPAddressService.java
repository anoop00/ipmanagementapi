package com.go.ipmanagement.ipmanagement.service;


import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;


public interface IPAddressService {

	IPPoolDTO generateIPAdress(int ipAmount, int poolId);
}
