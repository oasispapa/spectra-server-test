package com.spectra.Spectra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.xml.transform.Result;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = {"/"})
@Slf4j
public class Controller {

    @PostMapping("")
    public @ResponseBody JsonNode responseTest(@RequestBody ReqDto reqDto) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String command = reqDto.getCommand();
        String subcommand = reqDto.getSubcommands();

        final Set<String> components = new HashSet<>(Arrays.asList(command, "SimpleImage"));
        String data = "";
        String path = "";

        if (components.contains(command)) {
            path = "SampleResponse/" + command + ".json";
        } else {
            throw new Exception("no subcommand !! ");
        }

        ClassPathResource cpr = new ClassPathResource(path);

        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
            log.info(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = objectMapper.readTree(data);
        return jsonNode;
    }

    @GetMapping("/res-spectra")
    public Mono<ResultEntity> resSpectra(@RequestParam String sessionKey, @RequestParam String msg) {
        SpectraCounselDto spectraCounselDto = SpectraCounselDto.builder()
                .sessionKey(sessionKey)
                .data(SpectraCounselDto.SpectraResponse.builder().msg(msg).build())
                .build();

        String url = "http://localhost:8081/counsel/v1/res-spectra";
        return WebClient.builder()
                .build().post().uri(url)
                .body(BodyInserters.fromValue(spectraCounselDto))
                .retrieve()
                .bodyToMono(ResultEntity.class);
    }
}