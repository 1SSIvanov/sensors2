package ru.ivanov.sensor2.emulator;

public class DStrategy implements EmulationStrategy {
	private int counter= 0;
	private int ticks = 0;
	private int value = 0;
	
	public DStrategy() {
		counter = 0;
		value = 0;
	}

	public void setTicks(int ticks) {
		this.ticks=ticks;
		
	}

	public void doEmulate(FakeSensor2 sensors) {
		counter++;
		if(counter<=ticks) {
			sensors.setValue(value);
		}else { 
			value = 1;
			sensors.setValue(value);
			if(counter==ticks*2) {
				counter=0;
				value=0;
			}
		}
		sensors.setValue(value);
	}

}
