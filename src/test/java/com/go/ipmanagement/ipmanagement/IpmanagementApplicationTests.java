package com.go.ipmanagement.ipmanagement;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.go.ipmanagement.ipmanagement.entity.IPPool;
import com.go.ipmanagement.ipmanagement.repository.IPPoolRepository;
import com.go.ipmanagement.ipmanagement.service.IPPoolService;

@RunWith(SpringRunner.class)
@SpringBootTest
class IpmanagementApplicationTests {

	@Autowired
	private IPPoolService iPPoolService;

	@MockBean
	private IPPoolRepository ipPoolRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testIPPoolService() {
		IPPool ipPool = new IPPool(1,"test",100,20,"1.0.0.0","1.0.0.10",null);		
		when(ipPoolRepository.findById(1).get()).thenReturn(ipPool);
		assertThat(iPPoolService.getIPPool(1).getIpPool().getId()).isEqualTo(1);
	}

}
