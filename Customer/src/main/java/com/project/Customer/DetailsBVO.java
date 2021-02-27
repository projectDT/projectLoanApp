package com.project.Customer;

public class DetailsBVO {
	
	private Integer id;
	private BasicInfoBVO basicInfo; 
	private String loanTenure; 
	private CommDetailsBVO commDetails;
	
	public DetailsBVO() {
	}

	public DetailsBVO(Integer id, BasicInfoBVO basicInfo, String loanTenure, CommDetailsBVO commDetails) {
		super();
		this.id = id;
		this.setBasicInfo(basicInfo);		 
		this.loanTenure = loanTenure;
		this.setCommDetails(commDetails);  	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BasicInfoBVO getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfoBVO basicInfo) {
		this.basicInfo = basicInfo;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public CommDetailsBVO getCommDetails() {
		return commDetails;
	}

	public void setCommDetails(CommDetailsBVO commDetails) {
		this.commDetails = commDetails;
	}
	
	
}
