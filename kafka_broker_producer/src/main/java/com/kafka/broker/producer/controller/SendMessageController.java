package com.kafka.broker.producer.controller;

import com.kafka.broker.producer.producer.AvroMessageProducer;
import com.kafka.broker.producer.producer.StringMessagekafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private StringMessagekafkaProducer stringMessagekafkaProducer;

    @Autowired
    private AvroMessageProducer avroMessageProducer;

    @GetMapping("/send/string/{message_count}")
    public void sendStringMessage(@PathVariable Double message_count){
        System.out.println("Sendding message..");

        for(int i = 0; i <= message_count; i++) {
            stringMessagekafkaProducer.sendMessage("message -> " + i);
        }
    }

    @GetMapping("/send/avro/{message_count}")
    public void sendAvroMessage(@PathVariable Double message_count){
        System.out.println("Sendding message..");

        for(int i = 0; i <= message_count; i++) {
            avroMessageProducer.sendAvro();
        }
    }

}
