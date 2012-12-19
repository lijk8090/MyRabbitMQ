package cn.com.infosec.myrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Value("${spring.rabbitmq.myexchange}")
	private String myexchange;

	@Value("${spring.rabbitmq.myroutingkey}")
	private String myroutingkey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(Object obj) {

		System.out.println("MySender: " + obj);
		rabbitTemplate.convertAndSend(myexchange, myroutingkey, obj);
	}

}
