package com.nagarro.training.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.dto.EmployeeDto;



@Service
public class EmployeeManagementService {
	public List<EmployeeDto> getAllEmployees() {
		String url = "http://localhost:8081/employees/";

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		ParameterizedTypeReference<List<EmployeeDto>> responseType = new ParameterizedTypeReference<List<EmployeeDto>>() {
		};
		ResponseEntity<List<EmployeeDto>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
		List<EmployeeDto> employeeDtos = response.getBody();
		return employeeDtos;
	}

	public EmployeeDto getEmployee(long id) {
		String url = "http://localhost:8081/employees/" + id;

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, EmployeeDto.class);
	}

	public void addEmployee(EmployeeDto employeeDto) {
		String url = "http://localhost:8081/employees/";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<EmployeeDto> request = new HttpEntity<>(employeeDto);
		restTemplate.postForObject(url, request, EmployeeDto.class);
	}

	public void updateEmployee(EmployeeDto employeeDto) {
		String url = "http://localhost:8081/employees/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<EmployeeDto> request = new HttpEntity<>(employeeDto);
		restTemplate.put(url, request);
	}

	public void deleteEmployee(long id) {
		String url = "http://localhost:8081/employees/" + id;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

}
