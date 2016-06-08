package workflow.page.navigator;

import java.util.Collection;
import java.util.LinkedList;

import com.exponentus.scripting._Session;
import com.exponentus.scripting._WebFormData;
import com.exponentus.scripting.event._DoPage;
import com.exponentus.scripting.outline._Outline;
import com.exponentus.scripting.outline._OutlineEntry;
import com.exponentus.scriptprocessor.page.IOutcomeObject;

public class MainNavigator extends _DoPage {

	@Override
	public void doGET(_Session session, _WebFormData formData) {
		Collection<IOutcomeObject> list = new LinkedList<IOutcomeObject>();

		_Outline common_outline = new _Outline(getLocalizedWord("workflow", session.getLang()), "common");
		common_outline.addEntry(new _OutlineEntry(getLocalizedWord("office_memo", session.getLang()), "officememo-view"));
		common_outline.addEntry(new _OutlineEntry(getLocalizedWord("incoming_documents", session.getLang()), "incoming-view"));
		common_outline.addEntry(new _OutlineEntry(getLocalizedWord("outgoing_documents", session.getLang()), "outgoing-view"));

		list.add(common_outline);

		addValue("outline_current", formData.getValueSilently("id").replace("-form", "-view"));
		addContent(list);
	}
}
