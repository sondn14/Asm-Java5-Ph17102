package com.asm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.model.Motobike;
import com.asm.reponsitory.IMotobikeReponsitory;

@Service
public class MotobikeService {
	
	 @Autowired
	 private IMotobikeReponsitory reponsitory;
	 
	 public List<Motobike> getAll(){
		 return reponsitory.findAll();
	 }
}
