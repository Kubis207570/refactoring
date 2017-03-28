package com.technologies.transition.cleancode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NumbersProcessor {

	Map<Integer, Integer> mapIntegerKeys = new HashMap<Integer, Integer>();
	private int MIN_VALUE = Integer.MIN_VALUE;
	private int MAX_VALUE = Integer.MAX_VALUE;
	
	public NumbersProcessor(List<Integer> i1) {
		addValueToMapAndChangeRangeForValuesFromList(i1);
	}
	
	public NumbersProcessor() {
		
	}
	
	public void addValueToMapAndChangeRangeForValuesFromList(List<Integer> valuesToCheck) {
		int i = 0;
		for (; i < valuesToCheck.size(); i++) {
			addValueToMapAndChangeRange(valuesToCheck.get(i));
		}
		
	}
	
	public void addValueToMapAndChangeRange(Integer valueInMap) {
		if (mapIntegerKeys.containsKey(valueInMap)) {
			Integer valuetoAdded = mapIntegerKeys.get(valueInMap);
			mapIntegerKeys.put(valueInMap, valuetoAdded +1);
		} else {
			mapIntegerKeys.put(1, 1);
		}
		
		if (valueInMap > MIN_VALUE) {
			MIN_VALUE = valueInMap;
		}
		
		if (valueInMap < MAX_VALUE) {
			MAX_VALUE = valueInMap;
		}
	}
	
	public int getValue(int key) {
		if (mapIntegerKeys.containsKey(key)) {
			return mapIntegerKeys.get(key);
		} else {
			return 0;
		}
	}
	
	public double returnWeightedMean() {
		
		double productOfMapValues = 0;
		double sumOfMapValues = 0;
		
		for (Entry<Integer, Integer> u : mapIntegerKeys.entrySet()) {
			sumOfMapValues += u.getValue();
			productOfMapValues += u.getKey() * u.getValue();
		}
		
		return productOfMapValues/sumOfMapValues;
	}
	
	public int getMinValue() {
		return MIN_VALUE;
	}
	
	public int getMaxValue() {
		return MAX_VALUE;
	}
	
}
