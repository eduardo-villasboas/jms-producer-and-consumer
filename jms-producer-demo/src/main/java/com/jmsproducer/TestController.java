package com.jmsproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jms.commons.QueueProducerConsumerMessage;

@RestController
@RequestMapping("/api/test-controller")
public class TestController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("/send-message")
	@ResponseBody
	public ResponseEntity<String> sendMessage() {
		final var message = new QueueProducerConsumerMessage("id-1234", "the message name.");
		jmsTemplate.convertAndSend("queue.queuetestone", message);
		return ResponseEntity.<String>ok("Ok. Message was sent.");
	}

}
