package com.asm.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.model.User;

@Repository
public interface IUserReponsitory extends JpaRepository<User, String>{

}
