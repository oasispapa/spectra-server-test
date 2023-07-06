package com.spectra.Spectra.stomp;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("")
    @SendTo("/topic/greetings")
    public ResFromSpectraSocketDto test() {
//        Message rtnMsg = new Message("server restcontroller !", "hihihi!");
        ResFromSpectraSocketDto dto = ResFromSpectraSocketDto.builder().talkId("1").__event_id__("NEW_MESSAGE").build();

        System.out.println(dto);
        return dto;
    }
}
