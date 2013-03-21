package com.duckranger.goodproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duckranger.goodproject.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
