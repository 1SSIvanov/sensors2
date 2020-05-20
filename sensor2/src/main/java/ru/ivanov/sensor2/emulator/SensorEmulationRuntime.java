package ru.ivanov.sensor2.emulator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.ivanov.sensor2.interfaces.SensorRuntime;
import ru.ivanov.sensor2.interfaces.sensors;
@Component
public class SensorEmulationRuntime extends Thread implements SensorRuntime{
	
	private static Logger Log = LoggerFactory.getLogger(SensorEmulationRuntime.class);
	
	@Value("${runtime.interval}")	
	private int runtimeInterval;
	
	@Autowired
	private Map<String, FakeSensor2> fakeSensor;
	
	public List<sensors> getSensors() {
		
		return fakeSensor
				.values()
				   .stream()
				   .map(fakeSensor -> fakeSensor.toPureSensor())
				   .collect(Collectors.toList());
	}
	public void run() {
		while (true) {
			emulate();
			try {
				sleep(runtimeInterval);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
		
		private void emulate() {
			fakeSensor.forEach((key, s) -> {
				s.emulate();
			//fakeSensor.forEach((str,value)->{
				//value.emulate();
				//System.out.println("Emulating sensors "+ value.getValue());
				//Log.info("Sensor: name= " + s.getName() + " value= " + s.getValue() );	
				

			});
	}
		
}
