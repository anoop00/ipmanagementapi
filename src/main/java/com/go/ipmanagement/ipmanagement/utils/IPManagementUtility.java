package com.go.ipmanagement.ipmanagement.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.go.ipmanagement.ipmanagement.constant.IPManagementConstant;
import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;

@Component
public class IPManagementUtility {

	/**
	 * This Method is Generation for IP is based on changing the last digit of IP.
	 * Initial 3 parts I have consider the constant not changeable This logic can be
	 * improved by according to requirement or create new method according to the
	 * requirement
	 * 
	 * @param pool
	 * @param ipAmount
	 * @return
	 */
	public List<IPAddress> generateIPAddress(IPPool pool, int ipAmount) {

		List<IPAddress> ipAddresses = new ArrayList<>();

		int start = 0;
		String[] startParts = new String[2];

		if (pool.getIpAddresses().size() == 0) {
			startParts = pool.getLowerBound().split(IPManagementConstant.ipRegex);
			start = Integer.parseInt(startParts[1]);
		} else {
			startParts = pool.getIpAddresses().stream().sorted((o1, o2) -> o2.getId() - o1.getId()).iterator().next()
					.getIpValue().split(IPManagementConstant.ipRegex);
			start = Integer.parseInt(startParts[1]) + 1;
		}

		for (int i = 0; i < ipAmount; i++) {
			IPAddress ipAddress = new IPAddress();
			ipAddress.setIpPool(pool);
			ipAddress.setIpValue(startParts[0] + (start + i));
			ipAddresses.add(ipAddress);
		}
		return ipAddresses;
	}
}
