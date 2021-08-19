package com.go.ipmanagement.ipmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.ipmanagement.ipmanagement.entity.IPAddress;

@Repository
public interface IPAddressRepository extends JpaRepository<IPAddress, Integer>{

}
