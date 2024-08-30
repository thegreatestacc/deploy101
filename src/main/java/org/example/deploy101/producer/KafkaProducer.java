package org.example.deploy101.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.deploy101.model.FileMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "config_topic";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static int counter = 100;

    public void sendMessageEachSecond() {

        while (counter > 0) {
            FileMetadata fileMetadata = new FileMetadata()
                    .setFileId(UUID.randomUUID())
                    .setFileName("file_name_" + counter)
                    .setFileSize(counter);
            try {
                Thread.sleep(1_000);
                this.send(fileMetadata);
                counter -= 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void send(FileMetadata fileMetadata) {
        kafkaTemplate.send(TOPIC, fileMetadata);
        log.info("message send from kafka producer - " + fileMetadata.getFileId());
    }
}
