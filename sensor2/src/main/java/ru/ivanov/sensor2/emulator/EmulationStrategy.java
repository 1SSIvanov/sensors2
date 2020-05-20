package ru.ivanov.sensor2.emulator;

public interface EmulationStrategy {
	void setTicks(int ticks);
	void doEmulate(FakeSensor2 sensors);
	
}
