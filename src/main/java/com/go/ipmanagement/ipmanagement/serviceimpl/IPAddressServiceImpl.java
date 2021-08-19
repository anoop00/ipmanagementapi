package com.go.ipmanagement.ipmanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.ipmanagement.ipmanagement.constant.IPManagementConstant;
import com.go.ipmanagement.ipmanagement.dto.IPAddressDTO;
import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.exception.IPPoolCustomException;
import com.go.ipmanagement.ipmanagement.exception.IPPoolNotFoundException;
import com.go.ipmanagement.ipmanagement.mapper.IPManagerDTOMapper;
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
	public IPAddressDTO generateIPAdress(int ipAmount, int poolId) {

		Optional<IPPool> ipPool = ipPoolRepository.findById(poolId);
		if (ipPool.isPresent()) {
			IPPool pool = ipPool.get();
			if (ipPoolValidations.validateAvailableIP(ipAmount, pool)) {
				List<IPAddress> ipAddress = iPManagementUtility.generateIPAddress(pool, ipAmount);
				ipAddressRepository.saveAll(ipAddress);
				pool.setIpAddresses(ipAddress);
				pool.setUsedCapacity(ipPool.get().getUsedCapacity() + ipAmount);
				return IPManagerDTOMapper.getAddressDTO(pool);
			} else {
				throw new IPPoolCustomException(IPManagementConstant.ipPoolErrorMessage + poolId);
			}
		} else {
			throw new IPPoolNotFoundException(IPManagementConstant.ipPoolNotFoundError + " : " + poolId);

		}

	}

}
