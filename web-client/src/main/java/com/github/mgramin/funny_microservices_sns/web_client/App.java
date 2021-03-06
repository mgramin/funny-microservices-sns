package com.github.mgramin.funny_microservices_sns.web_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class App {

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
	}

}

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/web-client")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

}
