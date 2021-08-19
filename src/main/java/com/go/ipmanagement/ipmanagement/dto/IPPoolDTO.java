package com.go.ipmanagement.ipmanagement.dto;

import java.util.List;

import com.go.ipmanagement.ipmanagement.entity.IPAddress;
import com.go.ipmanagement.ipmanagement.entity.IPPool;


import lombok.Data;


@Data
public class IPPoolDTO {

	private IPPool ipPool;
	private List<IPAddress> ipAddress;
}
