package com.example.springbootwildfly;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private SortedSet<String> names = new TreeSet<>();

	@GetMapping("/")
	public String ping() {
		return "Pong";
	}

	@ApiOperation(value = "Insert a new name into the list", notes = "Remember that is a example POST method. ", response = String.class, produces = "text/plain", consumes = "text/plain")	
	@PostMapping(value = "/name", consumes = { MediaType.TEXT_PLAIN_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> hello(@RequestBody String name) {
		names.add(name);
		return ResponseEntity.status(HttpStatus.CREATED).body("Greetings " + name);
	}

	@GetMapping(value = "/names", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SortedSet<String>> helloAll() {
		return ResponseEntity.ok(names);
	}

}
