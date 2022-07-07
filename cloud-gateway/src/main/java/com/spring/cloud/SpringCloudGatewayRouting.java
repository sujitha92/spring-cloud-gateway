package com.spring.cloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
	
	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
	       return builder.routes()
	      .route("r1", r->r.path("/fraud-check/**").uri("http://localhost:8082")) //static routing
	      .route("r2", r->r.path("/customer/**").uri("lb://customer")) //dynamic routing
	      .build();
	    }

}
