package ru.ivanov.sensor2;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class Stub implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Object o = exchange.getIn().getBody();
		
	}

}
