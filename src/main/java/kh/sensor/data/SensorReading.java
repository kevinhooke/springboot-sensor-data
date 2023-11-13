package kh.sensor.data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SensorReading {

	private @Id @GeneratedValue Long id;
	
	private String sensorName;
	private LocalDateTime readingTime;
	private Float value;
	
	public SensorReading() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public LocalDateTime getReadingTime() {
		return readingTime;
	}

	public void setReadingTime(LocalDateTime readingTime) {
		this.readingTime = readingTime;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	
	
}
