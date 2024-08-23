package org.example.deploy101.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "deploy101-topic", groupId = "deploy101-group")
    public void consume(String message) {
        log.info("consumed message - " + message);
    }

}
