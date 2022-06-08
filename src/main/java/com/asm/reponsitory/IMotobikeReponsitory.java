package com.asm.reponsitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.model.Motobike;

public interface IMotobikeReponsitory extends JpaRepository<Motobike, Integer>{
	Page<Motobike> findAll(Pageable pageable);
}
