package com.asm.reponsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asm.model.Motobike;
import com.asm.model.MotobikeCompany;

public interface IMotobikeReponsitory extends JpaRepository<Motobike, Integer>{
	Page<Motobike> findAll(Pageable pageable);
	List<Motobike> findByMotobikeId(Integer motobikeId);
	
	@Query("select sp from Motobike sp where sp.motobikeCompany= :company")
	public Page<Motobike> findMotobikeByMotobikeCompany(@Param("company") MotobikeCompany company, Pageable pageable);
	
	@Query("select sp from Motobike sp where sp.motobikeName like %:motobikeName%")
	public List<Motobike> findByMotobikeNameLike(@Param("motobikeName") String motobikeName);
	
}
