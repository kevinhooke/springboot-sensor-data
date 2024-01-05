package kh.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.sensor.data.SensorReading;
import kh.sensor.repository.SensorReadingRepository;

@RestController
public class SensorService {

	@Autowired
	private SensorReadingRepository readingRepository;
	
	@GetMapping (path = "/reading")
	public SensorReading getReading() {
		//TODO
		return new SensorReading();
	}
	
	@PostMapping (path = "/reading")
	public SensorReading saveReading(SensorReading reading) {
		SensorReading result = readingRepository.save(reading);
		return result;
	}
}
