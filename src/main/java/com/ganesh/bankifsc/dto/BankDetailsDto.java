package com.ganesh.bankifsc.dto;

import java.io.Serializable;

import com.ganesh.bankifsc.entity.Branch;

public class BankDetailsDto implements Serializable {
	private static final long serialVersionUID = 1095903919852228801L;
	private long id;
	private String name;
	private String ifsc;

	private String branch;
	private String address;

	private String city;

	private String district;

	private String state;

	public BankDetailsDto(long id, String name, String ifsc, String branch, String address, String city,
			String district, String state) {
		super();
		this.id = id;
		this.name = name;
		this.ifsc = ifsc;
		this.branch = branch;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public static BankDetailsDto convertToDto(Branch branch) {
		return new BankDetailsDto(branch.getBank().getId(),branch.getBank().getName(),branch.getIfsc(), branch.getBranch(), branch.getAddress(), branch.getCity(), branch.getDistrict(), branch.getState());
	}

}
