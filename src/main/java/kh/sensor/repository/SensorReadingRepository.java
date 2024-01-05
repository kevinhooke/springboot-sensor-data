package kh.sensor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kh.sensor.data.SensorReading;

@Repository
public interface SensorReadingRepository
    extends CrudRepository<SensorReading, Long> {
}