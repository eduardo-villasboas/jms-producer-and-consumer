package com.jms.commons;

import java.io.Serializable;

public class QueueProducerConsumerMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	public QueueProducerConsumerMessage(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "QueueProducerMessage [id=" + id + ", name=" + name + "]";
	}

}
