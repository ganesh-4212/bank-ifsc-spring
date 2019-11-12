package com.ganesh.bankifsc.service;

import java.util.List;
import java.util.Optional;

import com.ganesh.bankifsc.dto.BankDetailsDto;

public interface BankDetailsService {
	public Optional<BankDetailsDto> getByIFSCCode(String ifscCode);

	public List<BankDetailsDto> getAll(Optional<String> bankName, Optional<String> city, int page, int size);
}
