package com.kafka.broker.consumer.consumer;

import com.kafka.teste.schema.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AvroMessageConsumer {

    @KafkaListener(topics = "${topic-avro-name}", groupId = "${group_id}", containerFactory = "kafkaAvroListenerContainerFactory")
    public void listenGroupFoo(Employee avro) {
        System.out.println("Received employee id: " + avro.getId());
    }

}
