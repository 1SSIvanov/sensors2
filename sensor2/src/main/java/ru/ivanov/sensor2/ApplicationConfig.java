package ru.ivanov.sensor2;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.ivanov.sensor2.emulator.FakeSensor2;
@Configuration
@ComponentScan(basePackages = {"ru.ivanov.sensor2"})
@PropertySource("classpath:application.properties")

public class ApplicationConfig {
	
	@Bean
	SensorsRoutes sensorsRoutes() {
		return new SensorsRoutes();
	}
	
	@Bean
	CamelContext camelContext() throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(sensorsRoutes());
		ctx.start();
		return ctx;
	}
	
	@Bean
	ApplicationContext xmlContext() {		
		return new ClassPathXmlApplicationContext("ApplicationConfig.xml");
}	


	@Bean
	public Map<String, FakeSensor2> fakeSensors() {		
		return xmlContext().getBeansOfType(FakeSensor2.class);
}

}
