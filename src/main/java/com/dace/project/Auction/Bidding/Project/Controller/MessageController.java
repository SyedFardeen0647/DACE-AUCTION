package com.dace.project.Auction.Bidding.Project.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
	@MessageMapping("**/ws/**")
	@SendTo("/topic/zain")
	public String modifyMessage(String message) {
		return message.toUpperCase();
	}
	
}

