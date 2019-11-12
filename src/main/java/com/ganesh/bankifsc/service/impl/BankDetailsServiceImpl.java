package com.ganesh.bankifsc.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ganesh.bankifsc.dto.BankDetailsDto;
import com.ganesh.bankifsc.entity.Branch;
import com.ganesh.bankifsc.repository.BranchRepository;
import com.ganesh.bankifsc.service.BankDetailsService;

@Transactional
@Service
public class BankDetailsServiceImpl implements BankDetailsService {
	@Autowired
	BranchRepository branchRepository;

	@Override
	public Optional<BankDetailsDto> getByIFSCCode(String ifscCode) {
		return branchRepository.findById(ifscCode).map(BankDetailsDto::convertToDto);
	}

	@Override
	public List<BankDetailsDto> getAll(Optional<String> bankName, Optional<String> city, int page, int size) {
		Specification<Branch> spec = null;
		if (bankName.isPresent()) {
			spec = withBankName(bankName.get());
		}
		if (city.isPresent()) {
			Specification<Branch> citySpec = withCity(city.get());
			spec = spec == null ? citySpec : spec.and(citySpec);
		}
		return branchRepository.findAll(spec, PageRequest.of(page, size)).map(BankDetailsDto::convertToDto).toList();
	}

	static Specification<Branch> withBankName(String bankName) {
		return (root, query, criteriaBuilder) -> {
			return criteriaBuilder.equal(criteriaBuilder.lower(root.get("bank").get("name")), bankName.toLowerCase());
		};
	}

	static Specification<Branch> withCity(String city) {
		return (root, query, criteriaBuilder) -> {
			return criteriaBuilder.equal(criteriaBuilder.lower(root.get("city")), city.toLowerCase());
		};
	}
}
