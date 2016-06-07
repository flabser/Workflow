package workflow.model;

import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author Kayra created 07-04-2016
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.exponentus.dataengine.jpa.SecureAppEntity;

import workflow.model.constants.DecisionType;

@Entity
@Table(name = "approvers")
@NamedQuery(name = "Approver.findAll", query = "SELECT m FROM Approver AS m ORDER BY m.regDate")
public class Approver extends SecureAppEntity<UUID> {

	@Column(name = "approver_user", nullable = false, updatable = false)
	protected Long approverUser;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true, length = 7, unique = true)
	private DecisionType type = DecisionType.UNKNOWN;

	@Column(name = "decision_time")
	private Date decisionTime;

	@Column(name = "decision_comment")
	private String decisionComment;

	@NotNull
	@ManyToOne(optional = false)
	private Block block;

	@Column(name = "is_current")
	private boolean isCurrent;

	public Long getApproverUser() {
		return approverUser;
	}

	public void setApproverUser(Long approverUser) {
		this.approverUser = approverUser;
	}

	public DecisionType getType() {
		return type;
	}

	public void setType(DecisionType type) {
		this.type = type;
	}

	public Date getDecisionTime() {
		return decisionTime;
	}

	public void setDecisionTime(Date decisionTime) {
		this.decisionTime = decisionTime;
	}

	public String getDecisionComment() {
		return decisionComment;
	}

	public void setDecisionComment(String decisionComment) {
		this.decisionComment = decisionComment;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

}
