package br.com.ApiStage3.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import br.com.ApiStage3.model.Usuario;

@Controller
public class MessageController {
	
	@MessageMapping("/join")
	@SendTo("/topic/response")
	public void join(@Payload Usuario user, SimpMessageHeaderAccessor acces) {
		System.out.println(user.getNome());
	}
}
