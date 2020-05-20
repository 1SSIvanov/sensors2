package ru.ivanov.sensor2;

import java.util.Date;
import java.util.List;

import ru.ivanov.sensor2.interfaces.sensors;

public interface SensorsJSONSchema {
	String getNode();
	
	default long getTimeStamp() {
		return new Date().getTime();
		
	}
	default List<sensors> getSensors(){
		return null;
	}
}
