package kh.sensor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.sensor.data.SensorReading;
import kh.sensor.repository.SensorReadingRepository;

@RestController
public class SensorService {

	@Autowired
	private SensorReadingRepository readingRepository;
	
	@GetMapping (path = "/reading/{id}")
	public Optional<SensorReading> getReading(@PathVariable Long id) {
		Optional<SensorReading> result = readingRepository.findById(id);
		return result;
	}
	
	@PostMapping (path = "/reading")
	public SensorReading saveReading(SensorReading reading) {
		SensorReading result = readingRepository.save(reading);
		return result;
	}
}
