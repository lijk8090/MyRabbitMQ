package cn.com.infosec.myrabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijk
 * 
 */
@Configuration
public class RabbitMQConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.rabbitmq.myqueue}")
	private String myqueue;
	@Value("${spring.rabbitmq.myqueue1}")
	private String myqueue1;
	@Value("${spring.rabbitmq.myqueue2}")
	private String myqueue2;

	@Value("${spring.rabbitmq.myexchange}")
	private String myexchange;

	@Value("${spring.rabbitmq.myroutingkey}")
	private String myroutingkey;

	@Bean
	Queue queue() {
		logger.info("queue");

		return new Queue(myqueue, false);
	}

	@Bean
	Queue queue1() {
		logger.info("queue1");

		return new Queue(myqueue1, false);
	}

	@Bean
	Queue queue2() {
		logger.info("queue2");

		return new Queue(myqueue2, false);
	}

	@Bean
	DirectExchange exchange() {
		logger.info("exchange");

		return new DirectExchange(myexchange);
	}

	/**
	 * 通过routingkey将queue和exchange绑定起来
	 * 
	 * @param queue
	 * @param exchange
	 * @return Binding
	 */
	@Bean
	Binding binding(@Qualifier("queue") Queue queue, DirectExchange exchange) {
		logger.info("binding");

		return BindingBuilder.bind(queue).to(exchange).with(myroutingkey);
	}

	@Bean
	Binding binding1(@Qualifier("queue1") Queue queue1, DirectExchange exchange) {
		logger.info("binding1");

		return BindingBuilder.bind(queue1).to(exchange).with(myroutingkey);
	}

	@Bean
	Binding binding2(@Qualifier("queue2") Queue queue2, DirectExchange exchange) {
		logger.info("binding2");

		return BindingBuilder.bind(queue2).to(exchange).with(myroutingkey);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
		logger.info("rabbitTemplate");

		RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}

}
