package com.resttemplate.consumingapi.service;

import com.resttemplate.consumingapi.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Service
public class ConsumingService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String getURL;

    public ConsumingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> fetchEmployeeData() {
        log.info(getURL + "/employees");
        return restTemplate.exchange(getURL + "/employees", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                }).getBody();
    }

    public void addEmployee(Employee employee) {
        HttpEntity<Employee> entity = new HttpEntity<>(employee);
        restTemplate.postForObject(getURL + "/employee", employee, String.class);
    }
}
