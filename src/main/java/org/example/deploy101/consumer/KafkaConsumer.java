package org.example.deploy101.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.deploy101.model.FileMetadata;
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

    private static final String TOPIC = "config_topic";
    private static final String GROUP = "config-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP)
    public void consume(FileMetadata fileMetadata) {
        log.info("consumed message - " + fileMetadata);
    }
}
