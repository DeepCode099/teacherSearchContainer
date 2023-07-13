package com.adj.internal.search.spi.model.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.kernel.search.Field;
import com.liferay.petra.string.StringPool;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "indexer.class.name=com.adj.model.Teacher", service = ModelSummaryContributor.class)
public class TeacherModelSummaryContributor implements ModelSummaryContributor{

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
		String languageId = LocaleUtil.toLanguageId(locale);
		
		// Need Some Work Function For This Summary
		return _createSummary(document, LocalizationUtil.getLocalizedName("name", languageId), LocalizationUtil.getLocalizedName("department", languageId));
	}
	
	private Summary _createSummary(Document document, String nameField, String departmentField) {
		String prefix = Field.SNIPPET + StringPool.UNDERLINE;
		
		Summary summary = new Summary(
			document.get(prefix + nameField, nameField),
			document.get(prefix + departmentField, departmentField)
		);
		
		summary.setMaxContentLength(200);
		
		return summary;
	}

}
