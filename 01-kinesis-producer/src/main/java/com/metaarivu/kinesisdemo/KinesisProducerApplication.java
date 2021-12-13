package com.metaarivu.kinesisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

@EnableScheduling
//@EnableBinding(Source.class)
@SpringBootApplication
public class KinesisProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisProducerApplication.class, args);
	}

//	@Autowired
//	private Source source;
	
//	long count =1;
//	@Scheduled(fixedRate = 500L)
//	public void sendMessage() {
//		String msg = "Hello-"+count+"-"+UUID.randomUUID().toString()+"-"+new Date();
//		boolean flag = source.output().send(MessageBuilder.withPayload(msg).build());
//		System.out.println("Produced Msg="+msg +", Status="+flag);
//		count++;
//	}
}
