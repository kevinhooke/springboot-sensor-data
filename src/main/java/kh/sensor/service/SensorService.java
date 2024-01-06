package kh.sensor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sensor.data.SensorReading;
import kh.sensor.repository.SensorReadingRepository;

@Service
public class SensorService {

	@Autowired
	private SensorReadingRepository readingRepository;

	
	public Optional<SensorReading> getReading(Long id) {
		Optional<SensorReading> result = readingRepository.findById(id);
		return result;
	}
	
	public SensorReading saveReading(SensorReading reading) {
		SensorReading result = readingRepository.save(reading);
		return result;
	}

	
}
