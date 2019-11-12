package com.ganesh.bankifsc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.bankifsc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("FROM User U where U.username=:username")
	Optional<User> findByUsername(@Param("username")String username);
}
