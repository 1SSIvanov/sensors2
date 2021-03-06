package ru.ivanov.sensor2;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.ivanov.sensor2.interfaces.SensorRuntime;

@Component
public class SensorsRuntimeProcessor implements Processor {
	
	@Autowired
	private SensorRuntime sensorRuntime;

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody(sensorRuntime.getSensors(), List.class);
	}

}
