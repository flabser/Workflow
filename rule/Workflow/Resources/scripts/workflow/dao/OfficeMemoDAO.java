package workflow.dao;

import java.util.UUID;

import kz.lof.dataengine.jpa.DAO;
import kz.lof.scripting._Session;
import workflow.model.OfficeMemo;

public class OfficeMemoDAO extends DAO<OfficeMemo, UUID> {

	public OfficeMemoDAO(_Session session) {
		super(OfficeMemo.class, session);
	}

}
