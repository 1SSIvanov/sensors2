package ru.ivanov.sensor2.emulator;
public class AStrategy implements EmulationStrategy{
		
	private int value;	
	
	public AStrategy() {
		value=0;		
	}
		
	@Override
	public void doEmulate(FakeSensor2 sensors) {
		
		 value = (int) (Math.random() * (100 + 1)) ;;
		sensors.setValue(value);			 
	}	

	@Override
	public void setTicks(int ticks) {
		// TODO Auto-generated method stub
		
	}
	
}


