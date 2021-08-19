package com.go.ipmanagement.ipmanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.repository.IPAddressRepository;
import com.go.ipmanagement.ipmanagement.repository.IPPoolRepository;
import com.go.ipmanagement.ipmanagement.service.IPAddressService;
import com.go.ipmanagement.ipmanagement.service.IPPoolService;

@RunWith(SpringRunner.class)
@SpringBootTest
class IpmanagementApplicationTests {

	@Autowired
	private IPPoolService iPPoolService;

	@Autowired
	private IPAddressService ipAddressService;

	@MockBean
	private IPPoolRepository ipPoolRepository;

	@MockBean
	private IPAddressRepository ipAddressRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testIPPoolService() {
		IPPool ipPool = new IPPool(1, "test", 100, 20, "1.0.0.0", "1.0.0.10", null);
		when(ipPoolRepository.findById(1)).thenReturn(Optional.of(ipPool));
		assertNotNull(iPPoolService.getIPPool(1).getIpPool());
		assertThat(iPPoolService.getIPPool(1).getIpPool().getId()).isEqualTo(1);
	}

	@Test
	public void testGenerateIPAddress() {
		IPPool ipPool = new IPPool(1, "test", 100, 20, "1.0.0.0", "1.0.0.10", null);
		IPAddress ipAddress = new IPAddress(1, ipPool, "1.0.0.1");
		ipPool.setIpAddresses(Arrays.asList(ipAddress));
		when(ipPoolRepository.findById(1)).thenReturn(Optional.of(ipPool));
		when(ipAddressRepository.saveAll(Arrays.asList(ipAddress))).thenReturn(Arrays.asList(ipAddress));
		assertEquals(1, ipAddressService.generateIPAdress(1, 1).getIpAddresses().size());
	}
}
