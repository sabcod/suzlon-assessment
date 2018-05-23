package com.suzlon.assessment.turbines.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurbineApi {
	
	static Map<String,Turbine> turbines = new HashMap<String,Turbine>();
	
	static public void createTurbines() {
		if(turbines.size() > 0)
			return;
		else {
			Turbine t1 = new Turbine("S111", 2100, 10, 3.0, 21);
			Turbine t2 = new Turbine("S128", 2100, 10, 3.0, 21);
			Turbine t3 = new Turbine("S52", 2100, 10, 3.0, 21);
			Turbine t4 = new Turbine("S66", 2100, 10, 3.0, 21);
			Turbine t5 = new Turbine("S82", 2100, 10, 3.0, 21);
			Turbine t6 = new Turbine("S88", 2100, 10, 3.0, 21);
			Turbine t7 = new Turbine("S97", 2100, 10, 3.0, 21);
			turbines.put(t1.getModel(),t1);
			turbines.put(t2.getModel(),t2);
			turbines.put(t3.getModel(),t3);
			turbines.put(t4.getModel(),t4);
			turbines.put(t5.getModel(),t5);
			turbines.put(t6.getModel(),t6);
			turbines.put(t7.getModel(),t7);
			
		}
	}
	
	public static ArrayList<Turbine> getTurbines(){
		createTurbines();
		return new ArrayList<>(turbines.values());
		
	}
	
	public static Turbine getTurbines(String arg){
		
		return turbines.get(arg);
		
	}
}
