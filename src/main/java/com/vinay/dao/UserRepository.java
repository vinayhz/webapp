package com.vinay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
