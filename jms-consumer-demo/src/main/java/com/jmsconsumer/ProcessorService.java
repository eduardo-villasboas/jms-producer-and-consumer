package com.jmsconsumer;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.ProducerCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jms.commons.TopicPublisherSubscriberMessage;

@Service
public class ProcessorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorService.class);

	private final JmsTemplate jmsTemplate;

	ProcessorService(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Transactional
	public void sendThousandTopicMessages() {
		LOGGER.info("sending 1000 messages.");

		for (var i = 0; i < 1000; ++i) {
			final var topicPublisherSubscriberMessage = new TopicPublisherSubscriberMessage(
					"id-321", "the topic name");

			LOGGER.info("SENT A MESSAGE.");


			final var messageConverter = jmsTemplate.getMessageConverter();
			final var producerCallback = new ProducerCallback<Void>() {

				@Override
				public Void doInJms(final Session session, final MessageProducer producer) throws JMSException {
					producer.send(messageConverter.toMessage(topicPublisherSubscriberMessage, session));
					session.commit();
					return null;
				}
				
			};

			final var DESTINATION_NAME = "topic.topictestone";
			jmsTemplate.execute(DESTINATION_NAME, producerCallback);
		}

		try {
			LOGGER.info("Waiting for 20 seconds");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			LOGGER.error("Error: {}", e);
			Thread.interrupted();
		} finally {
			LOGGER.info("Finishing Transaction.");
		}
	}

}
