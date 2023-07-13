package com.adj.internal.search.spi.model.index.contributor;

import com.adj.model.Teacher;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;


/**
 * @author Amit
 * The Model Contributor Contributes or Controls Which Field Are Indexed.
 * This Class Contribute Method Is Called Each Time The Add or Update Method In Entity Service Layer Are Called.
 *
 */
@Component(immediate = true, property = "indexer.class.name=com.adj.model.Teacher", service = ModelDocumentContributor.class)
public class TeacherModelDocumentContributor implements ModelDocumentContributor<Teacher>{

	@Override
	public void contribute(Document document, Teacher teacher) {
		String name = HtmlUtil.stripHtml(teacher.getName());
		document.addText("name", name);
		
		String department = HtmlUtil.stripHtml(teacher.getDepartment());
		document.addText("department", department);
		
		document.addDate("modifiedDate", teacher.getModifiedDate());
		
		// Handle Localized Data
		for(Locale locale : LanguageUtil.getAvailableLocales()) {
			String languageId = LocaleUtil.toLanguageId(locale);
			
			document.addText(LocalizationUtil.getLocalizedName("name", languageId), name);
			document.addText(LocalizationUtil.getLocalizedName("department", languageId), department);
		}
	}
}

