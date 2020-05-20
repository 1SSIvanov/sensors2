package ru.ivanov.sensor2;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.ivanov.sensor2.emulator.DStrategy;
import ru.ivanov.sensor2.emulator.EmulationStrategy;
import ru.ivanov.sensor2.emulator.FakeSensor2;

public class DStrategyTest {
@Test
public void testDStrategy() {
	int TESTS_AMONT=713;
	int ticks = 10;
	int testingValue = 0;
	
	FakeSensor2 sensor = new FakeSensor2();
	EmulationStrategy strategy = new DStrategy();
	strategy.setTicks(ticks);
	sensor.setEmulationStrategy(strategy);
	
	testingValue=0;
	ticks=47;
	strategy.setTicks(ticks);
	
	for(int i=0;i<TESTS_AMONT;i++) {
		sensor.emulate();
		
		if((i!=0) && (i%ticks==0)) {
			if(testingValue==1) {
				testingValue=0;
			}else {
				testingValue=1;
			}
			assertEquals(sensor.getValue(),testingValue);
		}
		
	}
	
}
	
}
