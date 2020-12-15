package com.cts.predictions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.predictions.client.RecommendationsClient;
import com.cts.predictions.model.ProductsBO;

@RequestMapping("/v1")
@RestController
public class PredictionsController {

	@Autowired
	RecommendationsClient  recommendationsClient;
	
	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "Hello world!";
	};
	
	@GetMapping(value = "/getPredictedResultsByConsumerId", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductsBO>> getPredictedResultsByConsumerId(@RequestParam("consumerId") String consumerId) throws Exception {
		return recommendationsClient.computeByConsumerId(consumerId);
	}
}
