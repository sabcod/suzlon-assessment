
package com.suzlon.assessment.turbines.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.suzlon.assessment.turbines.api.Turbine;

public class TurbineDetails {
	@Inject
	ESelectionService selectionService;
	
	Label modelName;
	Label ratedPowerLabel;
	Label cutInWindSpeedLabel;
	Label ratedWindSpeedLabel;
	Label cutOutWindSpeedLabel;
	
	Text modelText;
	Text ratedPowerText;
	Text cutInWindSpeedText;
	Text ratedWindSpeedText;
	Text cutOutWindSpeedText;
	
	Turbine turbineSelected;

	@PostConstruct
	public void postConstruct(Composite parent) {
		System.out.println("TurbineDetails.postConstruct()");
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
		
		modelName = new Label(composite, SWT.None);
		modelName.setText("Model");
		modelName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		modelText = new Text(composite, SWT.NONE);
		modelText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		ratedPowerLabel = new Label(composite, SWT.None);
		ratedPowerLabel.setText("Rated Power");
		ratedPowerLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		ratedPowerText = new Text(composite, SWT.NONE);
		ratedPowerText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		cutInWindSpeedLabel = new Label(composite, SWT.None);
		cutInWindSpeedLabel.setText("Cut-In Wind Speed");
		cutInWindSpeedLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		cutInWindSpeedText = new Text(composite, SWT.NONE);
		cutInWindSpeedText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		ratedWindSpeedLabel = new Label(composite, SWT.None);
		ratedWindSpeedLabel.setText("Rated Wind Speed");
		ratedWindSpeedLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		ratedWindSpeedText = new Text(composite, SWT.NONE);
		ratedWindSpeedText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		cutOutWindSpeedLabel = new Label(composite, SWT.None);
		cutOutWindSpeedLabel.setText("Cut-Out Wind Speed");
		cutOutWindSpeedLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		cutOutWindSpeedText = new Text(composite, SWT.NONE);
		cutOutWindSpeedText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		updateDetails();
		
	}
	
	private void updateDetails() {
		if(modelText != null )
			modelText.setText(turbineSelected.getModel());
		if(ratedPowerText != null )
			ratedPowerText.setText(String.valueOf(turbineSelected.getRatedPower())+" "+"kW");
		if(cutInWindSpeedText != null )
			cutInWindSpeedText.setText(String.valueOf(turbineSelected.getCutInWindSpeed())+" "+"m/s");
		if( ratedWindSpeedText!= null )
			ratedWindSpeedText.setText(String.valueOf(turbineSelected.getCutInWindSpeed())+" "+"m/s");
		if( cutOutWindSpeedText!= null )
			cutOutWindSpeedText.setText(String.valueOf(turbineSelected.getCutOutWindSpeed())+" "+"m/s");
	}

	@Inject
	public void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ISelection selection) {
		if(selection instanceof StructuredSelection) {
			IStructuredSelection selected = (IStructuredSelection)selection;
			System.out.println("Selected Turbine  ::" +((Turbine)selected.getFirstElement()).getModel());
			turbineSelected = ((Turbine)selected.getFirstElement());
			updateDetails();
		}
	}

}