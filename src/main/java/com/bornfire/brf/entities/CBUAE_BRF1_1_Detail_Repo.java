package com.bornfire.brf.entities;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_1_Detail_Repo extends JpaRepository<CBUAE_BRF1_1_Detail_Entity, String> {

	@Query(value = "select * from CBUAE_BRF1_1_DETAILTABLE  ", nativeQuery = true)
	List<CBUAE_BRF1_1_Detail_Entity> getdatabydateList(Date reportdate);
}
