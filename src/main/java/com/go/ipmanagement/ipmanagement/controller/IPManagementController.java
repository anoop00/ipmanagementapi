package com.go.ipmanagement.ipmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.go.ipmanagement.ipmanagement.dto.IPPoolDTO;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;

@RestController
public class IPManagementController {

	@Autowired
	private IPAddressService ipAddressService;

	@PostMapping("/generateIP")
	public IPPoolDTO generateIPAddress(@RequestParam(value = "poolId") int poolId,
			@RequestParam(value = "ipAmount") int amount) {
		IPPoolDTO ipPoolDTO = ipAddressService.generateIPAdress(amount, poolId);
		return ipPoolDTO;
	}

	@GetMapping("/getIPPool")
	public IPPoolDTO getIPPool(@PathVariable("id") int poolId) {

		return null;
	}
}
