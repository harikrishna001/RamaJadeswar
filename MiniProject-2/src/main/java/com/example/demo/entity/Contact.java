package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name = "CONTACT_EMAIL")
	private String  contactEmail;
	
	@CreationTimestamp    // edi vachhi automatic date set avuthadi record tho patu manually ga manam set cheyaballdu
	@Column(name = "CREATED_DATE", updatable=false) // false emduku amte update chesinappudu kimda variable execute edi execute kakaudadu edi first time create ayyetappudu updated appudu edi modifie avvakudadu danikosam imkoti kimda rasam amdukani update chesthe record false nuvvu false updateavva vaddu ani ardam
	private LocalDate  createdDate; //this coulmn reprsent when the record is inserted ani
	
	
	@UpdateTimestamp // edi vachhi date record ni modifie ayenappudu automatic ga modifie ayena date anedi set avvali ok
	@Column(name = "UPDATED_DATE",insertable = false) // record insert ayyetappudu edi reponse kakudadu date  set kakaudadu record update ayethene date anedi ravali ok.
	private LocalDate updatedDate; //edi record updarte chesthe eppudu insert ani time chupisthadi ok

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", contactEmail=" + contactEmail + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
	
	
	
	//@Entity pettam kabatti [embeded] database lo table create application run avvagane [application.prperties] lo kuda alane ichham ok.
	
}
