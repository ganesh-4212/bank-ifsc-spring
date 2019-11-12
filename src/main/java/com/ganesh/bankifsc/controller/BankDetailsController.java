package com.ganesh.bankifsc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.bankifsc.dto.BankDetailsDto;
import com.ganesh.bankifsc.service.BankDetailsService;

@RestController
@RequestMapping("/branches")
public class BankDetailsController {
	@Autowired
	BankDetailsService bankDetailsService;

	@GetMapping("/{ifscCode}")
	Optional<BankDetailsDto> getByIFSCCode(@PathVariable("ifscCode") String ifscCode) {
		return bankDetailsService.getByIFSCCode(ifscCode);
	}

	@GetMapping()
	List<BankDetailsDto> getByBankNameAndCity(@RequestParam("bankName") Optional<String> bankName,
			@RequestParam("city") Optional<String> city, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		return bankDetailsService.getAll(bankName, city, page, size);
	}

}
