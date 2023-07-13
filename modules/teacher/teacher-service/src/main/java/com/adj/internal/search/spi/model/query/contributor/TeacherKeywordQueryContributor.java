package com.adj.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;




/**
 * @author Amit
 * The Keyword Query Contributor Contributes To The Model-Specific Clauses To The Ongoing Search
 *
 */
@Component(immediate = true, property = "indexer.class.name=com.adj.model.Teacher", service = KeywordQueryContributor.class)
public class TeacherKeywordQueryContributor implements KeywordQueryContributor{

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
	SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();
		
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, "name", false);
		queryHelper.addSearchLocalizedTerm(booleanQuery, searchContext, "department", false);
		
	}
	
	@Reference
	protected QueryHelper queryHelper;

}
