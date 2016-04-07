package workflow.page.view;

import kz.lof.scripting._Session;
import kz.lof.scripting._WebFormData;
import kz.lof.scripting.event._DoPage;

public abstract class AbstractWorkflowView extends _DoPage {

	@Override
	public abstract void doGET(_Session session, _WebFormData formData);

	@Override
	public abstract void doDELETE(_Session session, _WebFormData formData);

}
