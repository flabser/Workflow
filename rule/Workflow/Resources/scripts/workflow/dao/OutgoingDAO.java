package workflow.dao;

import com.exponentus.dataengine.jpa.DAO;
import com.exponentus.scripting._Session;
import workflow.model.Incoming;
import workflow.model.Outgoing;

import java.util.UUID;

public class OutgoingDAO extends DAO<Outgoing, UUID> {

	public OutgoingDAO(_Session session) {
		super(Outgoing.class, session);
	}

}
