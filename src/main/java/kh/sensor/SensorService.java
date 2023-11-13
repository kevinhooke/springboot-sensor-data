package kh.sensor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.sensor.data.SensorReading;

@RestController
public class SensorService {

	//@GetMapping (path = "/reading")
//	public String getReading() {
//		
//	}
	
	@PostMapping (path = "/reading")
	public void saveReading(SensorReading reading) {
		
	}
}
