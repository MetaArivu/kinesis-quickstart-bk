package com.metaarivu.kinesisdemo;

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

	@Scheduled(fixedRate = 5000L)
	public void sendMessage() {
		StockService.getInstance().currentPrice().forEach(stock -> {
			String msg = stock.toCSV();
			boolean flag = source.output().send(MessageBuilder.withPayload(msg).build());
			System.out.println("Produced Msg=" + msg + ", Status=" + flag);
		});
	}

}
