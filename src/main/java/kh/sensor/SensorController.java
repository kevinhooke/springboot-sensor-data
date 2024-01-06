package kh.sensor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.sensor.data.SensorReading;
import kh.sensor.service.SensorService;

@RestController
public class SensorController {

	@Autowired
	private SensorService service;
	
	@GetMapping (path = "/reading/{id}")
	public Optional<SensorReading> getReading(@PathVariable Long id) {
		Optional<SensorReading> result = service.getReading(id);
		return result;
	}
	
	@PostMapping (path = "/reading")
	public SensorReading saveReading(SensorReading reading) {
		SensorReading result = service.saveReading(reading);
		return result;
	}
}
