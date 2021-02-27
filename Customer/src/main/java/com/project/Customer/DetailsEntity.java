package com.project.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name="customertable")
public class DetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "basic_id")			//check if there's any error cause of basicInfo Camel case
	private BasicInfoBVO basicinfo;  		//change it to basicinfo everywhere
											
	@Column(name = "loantenure")
	private String loanTenure;   
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "comm_id")
	private CommDetailsBVO commdetails;  	//check
	
	public DetailsEntity() {
	}
	
	public DetailsEntity(Integer id, BasicInfoBVO basicinfo, String loanTenure, CommDetailsBVO commdetails) {
		super();
		this.id = id;
		this.setBasicInfo(basicinfo);		 
		this.loanTenure = loanTenure;
		this.setCommDetails(commdetails); 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BasicInfoBVO getBasicInfo() {
		return basicinfo;
	}

	public void setBasicInfo(BasicInfoBVO basicinfo) {
		this.basicinfo = basicinfo;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public CommDetailsBVO getCommDetails() {
		return commdetails;
	}

	public void setCommDetails(CommDetailsBVO commdetails) {
		this.commdetails = commdetails;
	}
		
}
