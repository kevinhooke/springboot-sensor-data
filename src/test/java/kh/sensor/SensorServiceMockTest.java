package kh.sensor;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import kh.sensor.data.SensorReading;

/**
 * Tests SensorService using WebMvcTest and MockMvc to mock the Controller responses.
 */
@WebMvcTest(SensorController.class)
public class SensorServiceMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SensorController service;

	@Test
	void testRetrieveSensorReading() throws Exception {
		
		SensorReading mockReading = new SensorReading();
		mockReading.setSensorName("mock sensor");
		//setup mock return
		when(service.getReading(Long.valueOf(1))).thenReturn(Optional.of(mockReading));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/reading/1"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.sensorName").value("mock sensor"));
	}
	
}
