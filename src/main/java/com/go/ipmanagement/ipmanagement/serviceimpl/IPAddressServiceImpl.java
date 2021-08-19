package com.go.ipmanagement.ipmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.repository.IPAddressRepository;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;

@Service
public class IPAddressServiceImpl implements IPAddressService {

	@Autowired
	private IPAddressRepository ipAddressRepository;

	@Override
	public List<IPPoolDTO> generateIPAdress(int ipAmount, int poolId) {

		return null;
	}

}
