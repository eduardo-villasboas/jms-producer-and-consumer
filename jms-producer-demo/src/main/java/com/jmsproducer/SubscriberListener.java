package com.jmsproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jms.commons.TopicPublisherSubscriberMessage;

@Component
public class SubscriberListener {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberListener.class);

	@JmsListener(destination = "topic.topictestone", containerFactory = "jmsTopicSubscriberFactory", concurrency = "1")
	public void topicSubscriberFactory(final TopicPublisherSubscriberMessage topicPublisherSubscriberMessage) {
		LOGGER.info("Message on subscriber {}", topicPublisherSubscriberMessage);
	} 
	
}
