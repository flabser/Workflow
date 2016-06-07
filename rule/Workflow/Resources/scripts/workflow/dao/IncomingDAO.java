package workflow.dao;

import java.util.UUID;

import com.exponentus.dataengine.jpa.DAO;
import com.exponentus.scripting._Session;

import workflow.model.Incoming;

public class IncomingDAO extends DAO<Incoming, UUID> {

	public IncomingDAO(_Session session) {
		super(Incoming.class, session);
	}

}
