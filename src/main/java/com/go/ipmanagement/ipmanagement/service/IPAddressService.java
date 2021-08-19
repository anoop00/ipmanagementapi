package com.go.ipmanagement.ipmanagement.service;


import com.go.ipmanagement.ipmanagement.dto.IPAddressDTO;
import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;


public interface IPAddressService {

	IPAddressDTO generateIPAdress(int ipAmount, int poolId);
}
