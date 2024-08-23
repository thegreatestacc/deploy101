package org.example.deploy101.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.deploy101.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public void sendMessageToKafka(@RequestParam String message) {
        kafkaProducer.send(message);
        log.info("message send from controller - " + message);
    }
}
