package com.go.ipmanagement.ipmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.mapper.IPPoolDTOMapper;
import com.go.ipmanagement.ipmanagement.repository.IPAddressRepository;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;
import com.go.ipmanagement.ipmanagement.service.IPPoolService;
import com.go.ipmanagement.ipmanagement.utils.IPManagementUtility;

@Service
public class IPAddressServiceImpl implements IPAddressService {

	@Autowired
	private IPAddressRepository ipAddressRepository;

	@Autowired
	private IPPoolService ipPoolService;

	@Autowired
	private IPManagementUtility iPManagementUtility;

	@Override
	public IPPoolDTO generateIPAdress(int ipAmount, int poolId) {

		IPPool ipPool = ipPoolService.getIPPool(poolId);
		List<IPAddress> ipAddress = iPManagementUtility.generateIPAddress(ipPool, ipAmount);

		List<IPAddress> ipAddresses = ipAddressRepository.saveAll(ipAddress);

		return IPPoolDTOMapper.getIPPoolDTO(ipPool, ipAddresses);
	}

}
