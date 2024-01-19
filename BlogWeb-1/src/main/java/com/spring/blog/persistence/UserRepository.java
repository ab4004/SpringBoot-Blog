package com.spring.blog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.blog.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
