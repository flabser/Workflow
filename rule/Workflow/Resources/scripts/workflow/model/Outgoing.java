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
@Table(name = "outgoings")
@NamedQuery(name = "Outgoing.findAll", query = "SELECT m FROM Outgoing AS m ORDER BY m.regDate")
public class Outgoing extends SecureAppEntity<UUID> {

	@Column(name = "reg_number")
	private String regNumber;

	@Column(name = "applied_reg_date")
	private Date appliedRegDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "outgoing_attachments", joinColumns = { @JoinColumn(name = "outgoing_id", referencedColumnName = "id") }, inverseJoinColumns = {
	        @JoinColumn(name = "attachment_id", referencedColumnName = "id") })
	private List<Attachment> attachments = new ArrayList<>();

	private Organization recipient;

	@Column(nullable = false)
	private String summary = "";

}
