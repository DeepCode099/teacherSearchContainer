package com.adj.internal.search.spi.model.index.contributor;

import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.portal.kernel.search.Document;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author Amit
 * The Model Indexer Writer Contributor Configures The Re-Indexing And Batch Re-Indexing Behavior For Model Entity.
 *
 */
@Component(immediate = true, property = "indexer.class.name=com.adj.model.Teacher", service = ModelIndexerWriterContributor.class)
public class TeacherModelIndexerWriterContributor implements ModelIndexerWriterContributor<Teacher>{

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod(
			(Teacher teacher) -> {
				Document documents = modelIndexerWriterDocumentHelper.getDocument(teacher);
				batchIndexingActionable.addDocuments(documents);
			}
		);
	}

	
	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(teacherLocalService.getIndexableActionableDynamicQuery());
	}
	
	@Override
	public long getCompanyId(Teacher teacher) {
		return teacher.getCompanyId();
	}
	
	@Reference
	private TeacherLocalService teacherLocalService;
	
	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}
