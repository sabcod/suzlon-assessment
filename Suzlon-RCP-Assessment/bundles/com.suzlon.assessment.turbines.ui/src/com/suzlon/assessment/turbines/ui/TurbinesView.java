
package com.suzlon.assessment.turbines.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.suzlon.assessment.turbines.api.Turbine;
import com.suzlon.assessment.turbines.api.TurbineApi;

public class TurbinesView {

	private HashMap<String, Turbine> turbinesMap;
	
	@Inject
    private ESelectionService selectionService;

    @Inject
    private EPartService partService;

    @Inject
    private EModelService modelService;

    @Inject
    private MApplication app;
    
    Map<String, MPart> mPartMap = new HashMap<String, MPart>();

	@PostConstruct
	public void postConstruct(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		  composite.setLayout(new GridLayout(1, false));
		  ListViewer listViewer = new ListViewer(composite);
		  listViewer.setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<Turbine>) inputElement).toArray();
			}
		});
		  
		  listViewer.setInput(TurbineApi.getTurbines());
		  listViewer.setLabelProvider(new LabelProvider() {
		      public Image getImage(Object element) {
		        return null;
		      }

		      public String getText(Object element) {
		        return ((Turbine)element).getModel();
		      }
		    });
		  
		  listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		      public void selectionChanged(SelectionChangedEvent event) {
//		        IStructuredSelection selection = (IStructuredSelection)event.getSelection();
//		        StringBuffer sb = new StringBuffer("Selection - ");
//		        sb.append("tatal " + selection.size() + " items selected: ");
//		        for(Iterator iterator = selection.iterator(); iterator.hasNext(); ) {
//		          sb.append(iterator.next() + ", ");
//		        }
//		        System.out.println(sb);
		    	  
		    	  selectionService.setSelection(event.getSelection());
					final List<MPartDescriptor> descriptors = app.getDescriptors();
			        descriptors.stream().forEach(descriptor -> {
			            final String viewID = descriptor.getElementId();
			            System.out.println("View IDs ::"+viewID);
			                final MPart mPart = partService.createPart(descriptor.getElementId());
			                mPartMap.put(mPart.getElementId(), mPart);
			        });

			            MPart viewDesc = null;
			            for (Entry<String, MPart> entry : mPartMap.entrySet()) {
			                final String key = entry.getKey();
			                if (key.equals("org.eclipse.ui.editorss")) {
			                    viewDesc = entry.getValue();
			                    break;
			                }
			            }
			            if (viewDesc != null) {
			                final MPartStack partStack = (MPartStack) modelService
			                        .find("org.eclipse.e4.primaryDataStack", app);

			                final MPartSashContainer saashContainerElement = (MPartSashContainer) modelService
			                        .find("com.daimler.pace4.demp.play.ex2.views.partsashcontainer.ex2", app);

			                if (partStack != null) {
			                    final List<MStackElement> children = partStack.getChildren();
			                    for (MStackElement mStackElement : children) {
			                        final String placeholderElementId = mStackElement.getElementId();
			                        final String partElementId = viewDesc.getElementId();
			                        if (placeholderElementId.equals(partElementId)) {
			                            mStackElement.setVisible(true);
			                            break;
			                        }
			                    }
			                    partStack.setVisible(true);
			                } else if (saashContainerElement != null) {
			                    final MPartStack partStackModelElement = modelService
			                            .createModelElement(MPartStack.class);
			                    partStackModelElement.setElementId("org.eclipse.e4.primaryDataStack");
			                    partStackModelElement.setContainerData("70");
			                    final List<MPartSashContainerElement> sashContainerChildren = saashContainerElement
			                            .getChildren();
			                    sashContainerChildren.add(partStackModelElement);
			                    final List<MStackElement> stackChildren = partStackModelElement.getChildren();
			                    stackChildren.add(viewDesc);
			                }

			                partService.showPart(viewDesc, PartState.ACTIVATE);
			            }
				
			  }
		    });
	}

	

//	 private TreeObject createTreeModel() {
//	        // building the map and set
//	        readTreeNodeProperties();
//
//	        final TreeParent root = new TreeParent("Model");
//
//	        for(String turbineName : turbinesMap.keySet()) {
//	        	TreeObject treeObj = new TreeObject(turbineName);
//	        	root.addChild(treeObj);
//	        }
//	       
//      	        return root;
//	    }

	 private void readTreeNodeProperties() {
	        turbinesMap = new HashMap<String,Turbine>();
	      
	        for(Turbine t : TurbineApi.getTurbines()) {
	        	turbinesMap.put(t.getModel(), t);
	        }

	        
	    }
}