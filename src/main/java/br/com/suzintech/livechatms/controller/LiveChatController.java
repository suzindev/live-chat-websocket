package br.com.suzintech.livechatms.controller;

import br.com.suzintech.livechatms.domain.ChatInput;
import br.com.suzintech.livechatms.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.util.HtmlUtils;

@Controller
@EnableWebSocketMessageBroker
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMessage(ChatInput input) {
        return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }
}
