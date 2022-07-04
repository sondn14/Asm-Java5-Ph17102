package com.asm.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asm.model.Motobike;
import com.asm.model.MotobikeCompany;
import com.asm.reponsitory.IMotobikeReponsitory;

@Service
public class MotobikeService {
	
	 @Autowired
	 private IMotobikeReponsitory reponsitory;
	 
	 public MotobikeService(IMotobikeReponsitory reponsitory) {
		super();
		this.reponsitory = reponsitory;
	}

	public List<Motobike> getAll(){
		 return reponsitory.findAll();
	 }
	 
	 public List<Motobike> getById(int motobikeId) {
		 return reponsitory.findByMotobikeId(motobikeId);
	 }
	 
	 public Motobike getOneMotobikeById(int motobikeId) {
		 return reponsitory.getById(motobikeId);
	 }
	 
	 public Motobike updateMotobike(Motobike motobike) {
		 Integer motobikeId = motobike.getMotobikeId();
		 if(motobikeId != null) {
			 Optional<Motobike> motobikeOp = reponsitory.findById(motobikeId);
			 if(motobikeOp.isPresent()) {
				 reponsitory.save(motobike);
				 return reponsitory.save(motobike);
			 }	 
		 }
		 return null;
	 }
	 
	 public Motobike addMotobike(Motobike motobike) {
		 motobike.setMotobikeId(null);
		 Calendar cal = Calendar.getInstance();
		 Date date = cal.getTime();
		 motobike.setCreatedate(date);
		 return reponsitory.save(motobike);
	 }
	 
	 public Motobike deleteMotobike(Integer motobikeId) {
		 Optional<Motobike> motobikeOp = reponsitory.findById(motobikeId);
		 if(motobikeOp.isPresent()) {
			 reponsitory.deleteById(motobikeId);
			 return motobikeOp.get();
		 }else {
			 return null;
		 }
	 }
	 
	 public Page<Motobike> findPage(int pageNumber){
		 Pageable pageable = PageRequest.of(pageNumber, 5);
		 return reponsitory.findAll(pageable);
	 }
	 
	 public Page<Motobike> findPageByType(int pageNumber){
		 Pageable pageable = PageRequest.of(pageNumber, 5);
		 return reponsitory.findAll(pageable);
	 }
	 
	 public Page<Motobike> getByCompany(MotobikeCompany motobikeCompany, int pageNumber){
		 Pageable pageable = PageRequest.of(pageNumber, 5);
		 return reponsitory.findMotobikeByMotobikeCompany(motobikeCompany, pageable);
	 }
	 
	 
	 
}
