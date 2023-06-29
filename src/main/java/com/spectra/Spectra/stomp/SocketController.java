package com.spectra.Spectra.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SocketController {
//    @MessageMapping("/chat")
//    @SendTo("/topic/greetings")
//    public Message chat(Message msg) throws Exception{
//        System.out.println("chat IN!!!" + msg.getText());
//        Thread.sleep(10000); // simulated delay
//        Message rtnMsg = new Message("server !", "hihihi!");
//        System.out.println(rtnMsg);
//        return rtnMsg;
//    }

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    public ResFromSpectraSocketDto chat(ResFromSpectraSocketDto msg) throws Exception{
        System.out.println("chat IN!!!!" + msg.getTalkId());
        Thread.sleep(10000); // simulated delay
        ResFromSpectraSocketDto dto = ResFromSpectraSocketDto.builder().talkId("TCKT0000000071").eventId("NEW_MESSAGE").build();
        System.out.println(dto);
        return dto;
    }


    @MessageMapping("/messages")
    public void messages() {
        System.out.println("MESSAGES IN!!!");
    }

    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(message.getName());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
