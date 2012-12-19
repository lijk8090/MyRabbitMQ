package cn.com.infosec.myrabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	@RabbitListener(queues = "${spring.rabbitmq.myqueue}")
	public void recvMsg(Object obj) {

		System.out.println("MyReceiver: " + obj);
	}

	@RabbitListener(queues = "${spring.rabbitmq.myqueue1}")
	public void recvMsg1(Object obj) {

		System.out.println("MyReceiver1: " + obj);
	}

	@RabbitListener(queues = "${spring.rabbitmq.myqueue2}")
	public void recvMsg2(Object obj) {

		System.out.println("MyReceiver2: " + obj);
	}

}
