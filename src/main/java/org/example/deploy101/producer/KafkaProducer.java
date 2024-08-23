package org.example.deploy101.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "deploy101-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
        log.info("message send from kafka producer - " + message);
    }
}
