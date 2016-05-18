package workflow.dao;

import com.exponentus.dataengine.jpa.DAO;
import com.exponentus.scripting._Session;
import workflow.model.Incoming;
import workflow.model.OfficeMemo;

import java.util.UUID;

public class IncomingDAO extends DAO<Incoming, UUID> {

	public IncomingDAO(_Session session) {
		super(Incoming.class, session);
	}

}
