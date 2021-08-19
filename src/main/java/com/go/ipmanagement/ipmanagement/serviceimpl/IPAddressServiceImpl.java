package com.go.ipmanagement.ipmanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.ipmanagement.ipmanagement.constant.IPManagementConstant;
import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.exception.IPPoolCustomException;
import com.go.ipmanagement.ipmanagement.mapper.IPPoolDTOMapper;
import com.go.ipmanagement.ipmanagement.repository.IPAddressRepository;
import com.go.ipmanagement.ipmanagement.repository.IPPoolRepository;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;
import com.go.ipmanagement.ipmanagement.utils.IPManagementUtility;
import com.go.ipmanagement.ipmanagement.validation.IPPoolValidations;

@Service
public class IPAddressServiceImpl implements IPAddressService {

	@Autowired
	private IPAddressRepository ipAddressRepository;

	@Autowired
	private IPPoolRepository ipPoolRepository;

	@Autowired
	private IPManagementUtility iPManagementUtility;

	@Autowired
	private IPPoolValidations ipPoolValidations;

	@Transactional
	@Override
	public IPPoolDTO generateIPAdress(int ipAmount, int poolId) {

		IPPool ipPool = ipPoolRepository.findById(poolId).get();
		if (ipPoolValidations.validateAvailableIP(ipAmount, ipPool)) {
			List<IPAddress> ipAddress = iPManagementUtility.generateIPAddress(ipPool, ipAmount);
			ipAddressRepository.saveAll(ipAddress);
			ipPool.setIpAddresses(ipAddress);
			ipPool.setUsedCapacity(ipPool.getUsedCapacity() + ipAmount);
			return IPPoolDTOMapper.getIPPoolDTO(ipPool);
		} else {
			throw new IPPoolCustomException(IPManagementConstant.ipPoolErrorMessage + poolId);
		}

	}

}
