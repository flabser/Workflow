package workflow.page.view;

import com.exponentus.scripting._Session;
import com.exponentus.scripting._WebFormData;
import com.exponentus.scripting.actions._Action;
import com.exponentus.scripting.actions._ActionBar;
import com.exponentus.scripting.actions._ActionType;
import workflow.dao.IncomingDAO;

public class IncomingView extends AbstractWorkflowView {

	@Override
	public void doGET(_Session session, _WebFormData formData) {
		_ActionBar actionBar = new _ActionBar(session);
		_Action newDocAction = new _Action(getLocalizedWord("new_", session.getLang()), "", "new_incoming");
		newDocAction.setURL("Provider?id=incoming-form");
		actionBar.addAction(newDocAction);
		actionBar.addAction(new _Action(getLocalizedWord("del_document", session.getLang()), "", _ActionType.DELETE_DOCUMENT));
		addContent(actionBar);

		addContent(getViewPage(new IncomingDAO(session), formData));
	}

	@Override
	public void doDELETE(_Session session, _WebFormData formData) {

	}
}
