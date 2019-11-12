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

	/**
	 * @apiVersion 1.0.0
	 * @api {get} /branches/:ifscCode Get Bank details by IFSC code.
	 * @apiName GetByIFSCCode
	 * @apiGroup Bank Details
	 * @apiParam {String} ifscCode Bank Branch IFSC code.
	 *
	 * @apiSuccess {Object} BankDetailsDto Bank branch details.
	 * @apiSuccess {Number} BankDetailsDto.id Bank id.
	 * @apiSuccess {String} BankDetailsDto.name Bank name.
	 * @apiSuccess {String} BankDetailsDto.ifsc Bank branch ifsc code.
	 * @apiSuccess {String} BankDetailsDto.branch Bank branch name.
	 * @apiSuccess {String} BankDetailsDto.address Bank branch address.
	 * @apiSuccess {String} BankDetailsDto.city Bank branch city.
	 * @apiSuccess {String} BankDetailsDto.district Bank branch district.
	 * @apiSuccess {String} BankDetailsDto.state Bank branch state.
	 */
	@GetMapping("/{ifscCode}")
	Optional<BankDetailsDto> getByIFSCCode(@PathVariable("ifscCode") String ifscCode) {
		return bankDetailsService.getByIFSCCode(ifscCode);
	}

	/**
	 * @apiVersion 1.0.0
	 * @api {get} /branches Get All Bank branch details (Paginated).
	 * @apiName GetByBankNameAndCity
	 * @apiGroup Bank Details
	 * @apiParam {String} bankName Bank name.
	 * @apiParam {String} city Bank branch city.
	 * @apiParam {Number} page Pagination page index (Zero based).
	 * @apiParam {Number} size Number of records per request.
	 *
	 * @apiSuccess {Object[]} BankDetailsDto Bank branch details.
	 * @apiSuccess {Number} BankDetailsDto.id Bank id.
	 * @apiSuccess {String} BankDetailsDto.name Bank name.
	 * @apiSuccess {String} BankDetailsDto.ifsc Bank branch ifsc code.
	 * @apiSuccess {String} BankDetailsDto.branch Bank branch name.
	 * @apiSuccess {String} BankDetailsDto.address Bank branch address.
	 * @apiSuccess {String} BankDetailsDto.city Bank branch city.
	 * @apiSuccess {String} BankDetailsDto.district Bank branch district.
	 * @apiSuccess {String} BankDetailsDto.state Bank branch state.
	 */
	@GetMapping()
	List<BankDetailsDto> getByBankNameAndCity(@RequestParam("bankName") Optional<String> bankName,
			@RequestParam("city") Optional<String> city, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		return bankDetailsService.getAll(bankName, city, page, size);
	}

}
