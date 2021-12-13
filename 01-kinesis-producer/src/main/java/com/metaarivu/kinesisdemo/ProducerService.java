package com.metaarivu.kinesisdemo;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class ProducerService {

	@Autowired
	private Source source;
	
	long count =1;
	@Scheduled(fixedRate = 500L)
	public void sendMessage() {
		String msg = "Hello-"+count+"-"+UUID.randomUUID().toString()+"-"+new Date();
		boolean flag = source.output().send(MessageBuilder.withPayload(msg).build());
		System.out.println("Produced Msg="+msg +", Status="+flag);
		count++;
	}
	
}
