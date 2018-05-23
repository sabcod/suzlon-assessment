package com.suzlon.assessment.application.intro;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroPart4 implements IIntroPart {

	private static final Logger LOG = LoggerFactory.getLogger("com.suzlon.assessment");
	
	@Override
	public IIntroSite getIntroSite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(IIntroSite site, IMemento memento) throws PartInitException {
		// TODO Auto-generated method stub

	}

	@Override
	public void standbyStateChanged(boolean standby) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartControl(Composite parent) {
		LOG.info("Starting welcome");
		Composite composite = new Composite(parent, SWT.COLOR_BLUE);
		composite.setLayout(new org.eclipse.swt.layout.GridLayout(2,false));
		Label label = new Label(composite, SWT.BOLD);
		label.setText("Welcome");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getTitleImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Welcome";
	}

	@Override
	public void removePropertyListener(IPropertyListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
