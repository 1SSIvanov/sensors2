package ru.ivanov.sensor2;

import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.ivanov.sensor2.interfaces.sensors;

@Component
public class EnrichDataProcessor implements Processor {
	
	@Value("${node.name}")
	private String nodeName;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		List<sensors> sensors = exchange.getIn().getBody(List.class);
		
		exchange.getIn().setBody(new SensorsJSONSchema(){

			@Override
			public String getNode() {				
				return nodeName;
			}
			public List<sensors> getSensors(){				
				return sensors;
			}
		});
	}
}