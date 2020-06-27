package com.jmsproducer;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
public class JmsProducerConfiguration {

	@Bean
	public JmsListenerContainerFactory<DefaultMessageListenerContainer> jmsTopicSubscriberFactory(
			ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
		final var factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setConcurrency("10-100");
		factory.setPubSubDomain(true);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		final var converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
