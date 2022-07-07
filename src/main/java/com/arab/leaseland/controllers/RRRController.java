package com.arab.leaseland.controllers;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.arab.leaseland.entity.PersonRequest;
import com.arab.leaseland.entity.RRRequest;
import com.arab.leaseland.util.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import reactor.core.publisher.Mono;

@RestController
public class RRRController {

	private WebClient client = WebClient.create("https://remitademo.net/remita/exapp/api/v1/send/api/echannelsvc/merchant/api/paymentinit");
	String merchantId = "2547916";
	String apiKey = "1946";
	String serviceTypeId = "4430731";
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> getRRR(@RequestBody PersonRequest personRequest) throws JsonMappingException, JsonProcessingException {
		
		Date date = new Date();
		long orderId = date.getTime();
		String apiHash = Converter.hashTheInput(merchantId+ serviceTypeId+ orderId+personRequest.getAmount()+apiKey);
		
		
		return client.post().bodyValue(new RRRequest(serviceTypeId, 
				personRequest.getAmount(), orderId, personRequest.getPayerName(), 
				personRequest.getPayerEmail(), personRequest.getPayerPhone(), personRequest.getDescription()))
		.header("Authorization", "remitaConsumerKey="+merchantId+",remitaConsumerToken="+apiHash)
		.header("Content-Type", "application/json")
//		.header("Accept", "application/json")
		.retrieve().bodyToMono(String.class);		
		
	}
	
}
