package com.suzlon.assessment.turbines.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class CustomTreeContentProvider implements ITreeContentProvider {
 private Map<String, String[]> contentMap = new HashMap<>();

 public CustomTreeContentProvider() {
  initMap();
 }

 private void initMap() {
  String[] roots = { "root1", "root2" };

  contentMap.put("roots", roots);

  contentMap.put("root1", new String[] { "root1_child1", "root1_child2", "root1_child3" });
  contentMap.put("root1_child1", new String[] { "root1_child1_child1", "root1_child1_child2" });
 }

 @Override
 public Object[] getElements(Object arg0) {
  return contentMap.get("roots");
 }

 @Override
 public void dispose() {
  // TODO Auto-generated method stub

 }

 @Override
 public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
  // TODO Auto-generated method stub

 }

 @Override
 public Object[] getChildren(Object arg0) {
  return contentMap.get(arg0);
 }

 @Override
 public Object getParent(Object arg0) {
  return getParentOfEle(arg0);
 }

 @Override
 public boolean hasChildren(Object arg0) {
  return contentMap.containsKey(arg0);
 }

 private String getParentOfEle(Object arg0) {
  Set<String> keys = contentMap.keySet();

  for (String key : keys) {
   String[] values = contentMap.get(key);

   for (String val : values) {
    if (val.equals(arg0)) {
     return key;
    }
   }
  }
  return null;
 }

}

