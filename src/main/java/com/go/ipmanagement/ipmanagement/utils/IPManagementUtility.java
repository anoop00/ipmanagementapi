package com.go.ipmanagement.ipmanagement.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;

@Component
public class IPManagementUtility {

	public List<IPAddress> generateIPAddress(IPPool pool, int ipAmount) {

		List<IPAddress> ipAddresses = new ArrayList<>();

		int start = 0;
		String[] startParts = new String[2];

		if (pool.getIpAddresses().size() == 0) {
			startParts = pool.getLowerBound().split("(?<=\\.)(?!.*\\.)");
			start = Integer.parseInt(startParts[1]);
		} else {
			startParts = pool.getIpAddresses().iterator().next().getIpValue().split("(?<=\\.)(?!.*\\.)");
			start = Integer.parseInt(startParts[1]) + 1;
		}

		for (int i = start; i < start + ipAmount; i++) {
			IPAddress ipAddress = new IPAddress();
			ipAddress.setIpPool(pool);
			ipAddress.setIpValue(startParts[0] + i);
			ipAddresses.add(ipAddress);
		}
		return ipAddresses;
	}
}
