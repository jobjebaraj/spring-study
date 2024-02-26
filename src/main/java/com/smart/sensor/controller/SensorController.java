package com.smart.sensor.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

	@GetMapping("/getSensor")
	public ResponseEntity<Object> getSensorById(@RequestParam("sensorId")Optional<Integer> sensorId) {
		return null;

	}

}
