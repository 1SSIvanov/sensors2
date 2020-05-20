package ru.ivanov.sensor2.emulator;

import ru.ivanov.sensor2.interfaces.sensors;

public class FakeSensor2 implements sensors {
	private EmulationStrategy  emulationStrategy;	
	private int value;	
	private String name;	
	public sensors toPureSensor() {
		return new sensors() {

			@Override
			public int getValue() {
				return value;
			}
			
			@Override
			public String getName() {				
				return name;
			}
			
		};
			
	}
	public void setValue(int value) {
		this.value=value;
		
	}
	
	public EmulationStrategy getEmulationStrategy() {
		return emulationStrategy;
	}
	public void setEmulationStrategy(EmulationStrategy emulationStrategy) {
		this.emulationStrategy = emulationStrategy;
		
	}
	public void emulate() {
		emulationStrategy.doEmulate(this);
	}
	public String getName() {
		return name;
	
	}
	public void setName(String name) {
			this.name = name;
	}
	public int getValue() {
		return value ;
	}
		

}
