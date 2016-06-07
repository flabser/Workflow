package workflow.model;

/**
 * 
 * @author Kayra created 07-04-2016
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.exponentus.common.model.Attachment;
import com.exponentus.dataengine.jpa.SecureAppEntity;

import staff.model.Organization;

@Entity
@Table(name = "incomings")
@NamedQuery(name = "Incoming.findAll", query = "SELECT m FROM Incoming AS m ORDER BY m.regDate")
public class Incoming extends SecureAppEntity<UUID> {

	@Column(name = "reg_number")
	private String regNumber;

	@Column(name = "applied_reg_date")
	private Date appliedRegDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "incoming_attachments", joinColumns = { @JoinColumn(name = "incoming_id", referencedColumnName = "id") }, inverseJoinColumns = {
	        @JoinColumn(name = "attachment_id", referencedColumnName = "id") })
	private List<Attachment> attachments = new ArrayList<>();

	private Organization sender;

	@Column(name = "sender_reg_number")
	private String senderRegNumber;

	@Column(name = "sender_applied_reg_date")
	private Date senderAppliedRegDate;

	@Column(nullable = false)
	private String summary = "";

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Date getAppliedRegDate() {
		return appliedRegDate;
	}

	public void setAppliedRegDate(Date appliedRegDate) {
		this.appliedRegDate = appliedRegDate;
	}

	public Organization getSender() {
		return sender;
	}

	public void setSender(Organization sender) {
		this.sender = sender;
	}

	public String getSenderRegNumber() {
		return senderRegNumber;
	}

	public void setSenderRegNumber(String senderRegNumber) {
		this.senderRegNumber = senderRegNumber;
	}

	public Date getSenderAppliedRegDate() {
		return senderAppliedRegDate;
	}

	public void setSenderAppliedRegDate(Date senderAppliedRegDate) {
		this.senderAppliedRegDate = senderAppliedRegDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
