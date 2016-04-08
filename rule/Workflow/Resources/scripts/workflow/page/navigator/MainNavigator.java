package workflow.page.navigator;

import java.util.ArrayList;
import java.util.List;

import kz.lof.scripting._Session;
import kz.lof.scripting._WebFormData;
import kz.lof.scripting.event._DoPage;
import kz.lof.scriptprocessor.page.IOutcomeObject;
import kz.nextbase.script.outline._Outline;
import kz.nextbase.script.outline._OutlineEntry;

public class MainNavigator extends _DoPage {

	@Override
	public void doGET(_Session session, _WebFormData formData) {
		List<IOutcomeObject> list = new ArrayList<IOutcomeObject>();

		_Outline common_outline = new _Outline(getLocalizedWord("workflow", session.getLang()), "common");
		common_outline.addEntry(new _OutlineEntry(getLocalizedWord("office_memo", session.getLang()), "officememo-view"));

		list.add(common_outline);

		addValue("outline_current", formData.getValueSilently("id").replace("-form", "-view"));
		addContent(list);
	}
}
