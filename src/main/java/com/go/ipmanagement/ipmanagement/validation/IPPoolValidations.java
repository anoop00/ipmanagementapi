package com.go.ipmanagement.ipmanagement.validation;

import org.springframework.stereotype.Component;

import com.go.ipmanagement.ipmanagement.entity.IPPool;

@Component
public class IPPoolValidations {

	public boolean validateAvailableIP(int ipAmount, IPPool ipPool) {

		if (ipAmount <= (ipPool.getTotalCapacity() - ipPool.getUsedCapacity()))
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
