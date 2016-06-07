package workflow.model;

/**
 * 
 * @author Kayra created 07-04-2016
 */

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.exponentus.dataengine.jpa.SecureAppEntity;

import workflow.model.constants.ApprovalStatusType;
import workflow.model.constants.ApprovalType;

@Entity
@Table(name = "blocks")
@NamedQuery(name = "Block.findAll", query = "SELECT m FROM Block AS m ORDER BY m.regDate")
public class Block extends SecureAppEntity<UUID> {

	@Enumerated(EnumType.STRING)
	@Column(nullable = true, length = 10)
	private ApprovalStatusType status = ApprovalStatusType.UNKNOWN;

	@OneToMany(mappedBy = "block", fetch = FetchType.EAGER)
	private List<Approver> approvers;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true, length = 8, unique = true)
	private ApprovalType type = ApprovalType.UNKNOWN;

	@Column(name = "require_comment_if_no")
	private boolean requireCommentIfNo;

	@Column(name = "time_limit")
	private int timeLimit;

	public ApprovalStatusType getStatus() {
		return status;
	}

	public void setStatus(ApprovalStatusType status) {
		this.status = status;
	}

	public List<Approver> getApprovers() {
		return approvers;
	}

	public void setApprovers(List<Approver> approvers) {
		this.approvers = approvers;
	}

	public ApprovalType getType() {
		return type;
	}

	public void setType(ApprovalType type) {
		this.type = type;
	}

	public boolean isRequireCommentIfNo() {
		return requireCommentIfNo;
	}

	public void setRequireCommentIfNo(boolean requireCommentIfNo) {
		this.requireCommentIfNo = requireCommentIfNo;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

}
