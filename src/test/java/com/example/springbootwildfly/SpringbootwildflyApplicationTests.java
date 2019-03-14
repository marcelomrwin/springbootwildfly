package com.example.springbootwildfly;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringbootwildflyApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private RestController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(restTemplate).isNotNull();
		assertThat(port).isGreaterThan(0);
	}

	@Test
	public void postHelloShouldReturnDefaultMessage() throws Exception {
		setTestRestTemplateContentType(MediaType.TEXT_PLAIN_VALUE);
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/name", "{\"name\":\"marcelo\"}",
				String.class)).contains("marcelo");
	}

	private void setTestRestTemplateContentType(String type) {
		restTemplate.getRestTemplate().setInterceptors(Collections.singletonList((request, body, execution) -> {
			request.getHeaders().remove("Content-type");
			request.getHeaders().add("Content-type", type);
			return execution.execute(request, body);
		}));
	}

}
