package com.go.ipmanagement.ipmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.go.ipmanagement.ipmanagement.dto.IPAddressDTO;
import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;
import com.go.ipmanagement.ipmanagement.service.IPPoolService;

@RestController
@RequestMapping("ipmanagement")
public class IPManagementController {

	@Autowired
	private IPAddressService ipAddressService;

	@Autowired
	private IPPoolService ipPoolService;

	@PostMapping("/generateip")
	public IPAddressDTO generateIPAddress(@RequestParam(value = "poolId") int poolId,
			@RequestParam(value = "ipAmount") int amount) {
		return ipAddressService.generateIPAdress(amount, poolId);
	}

	@GetMapping("/getippool/{id}")
	public IPPoolDTO getIPPool(@PathVariable("id") int poolId) {
		return ipPoolService.getIPPool(poolId);
	}
}
