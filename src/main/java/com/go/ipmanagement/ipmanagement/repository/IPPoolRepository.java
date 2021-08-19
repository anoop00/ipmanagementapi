package com.go.ipmanagement.ipmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.ipmanagement.ipmanagement.entity.IPPool;

@Repository
public interface IPPoolRepository extends JpaRepository<IPPool, Integer>{

}
