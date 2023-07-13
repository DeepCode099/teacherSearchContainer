package com.adj.teacher.internal.search;

import com.adj.model.Teacher;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.search.Field;



/**
 * @author Amit
 * 
 * This Class Register's Assignment Entity And Search Framework
 *
 */
@Component(immediate = true)
public class TeacherSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		serviceRegistration = modelSearchRegistrarHelper.register(Teacher.class, bundleContext,
				modelSearchDefinition -> {
					modelSearchDefinition.setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID,
							Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE,
							Field.SCOPE_GROUP_ID, Field.UID);
					modelSearchDefinition.setDefaultSelectedLocalizedFieldNames("name", "department");
					modelSearchDefinition.setModelIndexWriteContributor(modelIndexerWriterContributor);
					modelSearchDefinition.setModelSummaryContributor(modelSummaryContributer);
				});
	}

	@Deactivate
	protected void deactivate() {
		serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.adj.model.Teacher)")
	protected ModelIndexerWriterContributor<Teacher> modelIndexerWriterContributor;

	@Reference(target = "(indexer.class.name=com.adj.model.Teacher)")
	protected ModelSummaryContributor modelSummaryContributer;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> serviceRegistration;

}
