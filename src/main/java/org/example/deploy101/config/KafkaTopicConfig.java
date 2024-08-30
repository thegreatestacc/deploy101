package org.example.deploy101.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var config = new HashMap<String, Object>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("config_topic", 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("config_topic_2", 1, (short) 1);
    }
}
