package com.go.ipmanagement.ipmanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.repository.IPPoolRepository;
import com.go.ipmanagement.ipmanagement.service.IPPoolService;

@Service
public class IPPoolServiceImpl implements IPPoolService{

	@Autowired
	private IPPoolRepository iPPoolRepository;
	
	@Override
	public IPPool getIPPool(int id) {
		return iPPoolRepository.findById(id).get();
	}
}
