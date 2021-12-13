package com.metaarivvu.kinesisconsumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class ConsumerService {

	@StreamListener("input")
	public void input(String msg) {
		System.out.println("Msg Consumed=" + msg);
	}
}
