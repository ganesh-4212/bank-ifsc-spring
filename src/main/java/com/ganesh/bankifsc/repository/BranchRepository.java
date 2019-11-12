package com.ganesh.bankifsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ganesh.bankifsc.entity.Branch;

@Repository
public interface BranchRepository  extends JpaRepository<Branch, String>, JpaSpecificationExecutor<Branch> {

}
