package com.jmsconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jms.commons.QueueProducerConsumerMessage;

@Component
public class ConsumerListenerComponet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListenerComponet.class);

	@Autowired
	private ProcessorService processorService;

	@JmsListener(destination = "queue.queuetestone", containerFactory = "consumerQueueFactory", concurrency = "2")
	public void consumerQueueTestOne(final QueueProducerConsumerMessage queueMessage) {
		LOGGER.info("received on consumerQueueTestOne: {}", queueMessage);
		processorService.sendThousandTopicMessages();
	}

}
