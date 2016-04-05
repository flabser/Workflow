package workflow.dao;

import java.util.UUID;

import kz.lof.dataengine.jpa.DAO;
import kz.lof.scripting._Session;
import workflow.model.Approval;

public class ApprovalDAO extends DAO<Approval, UUID> {

	public ApprovalDAO(_Session session) {
		super(Approval.class, session);
	}

}
