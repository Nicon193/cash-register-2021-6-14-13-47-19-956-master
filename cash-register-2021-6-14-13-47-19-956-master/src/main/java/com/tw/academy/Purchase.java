package com.tw.academy;

import java.time.LocalDateTime;

public class Purchase {
	private final LocalDateTime timestamp;

	public Purchase() {
		timestamp = LocalDateTime.now();
	}

	public String asString() {
		// very time-consuming operation, connecting network to get content
		String content = "content";
		return content + timestamp.toString();
	}
}
