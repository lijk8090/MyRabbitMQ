package cn.com.infosec.myrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.infosec.myrabbitmq.entity.UserEntity;
import cn.com.infosec.myrabbitmq.service.ProducerService;

@SpringBootTest
class MyRabbitMqApplicationTests {

	@Autowired
	ProducerService producer;

	@Test
	void testSender() {

		UserEntity user = new UserEntity();
		producer.sendMsg(user);

		user.setPassword("12345678");
		producer.sendMsg(user);
	}

}
