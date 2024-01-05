package kh.sensor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import kh.sensor.data.SensorReading;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SensorServiceTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void saveReading() throws Exception {
		
		SensorReading reading = new SensorReading();
		reading.setSensorName("test");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		HttpEntity<SensorReading> request = 
			      new HttpEntity<SensorReading>(reading, headers);
		
		SensorReading result = this.restTemplate.postForObject("http://localhost:" + port + "/reading",
				request, SensorReading.class);

		System.out.println("Saved id: " + result.getId());
		
		//get reading
		SensorReading result2 = this.restTemplate.getForObject("http://localhost:" + port + "/reading",
				SensorReading.class);
		assertNotNull(result2);
	}
	
}
