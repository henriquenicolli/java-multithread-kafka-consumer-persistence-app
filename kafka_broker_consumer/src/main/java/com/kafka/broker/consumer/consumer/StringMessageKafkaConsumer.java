package com.kafka.broker.consumer.consumer;

import com.kafka.broker.consumer.model.MensagemEntity;
import com.kafka.broker.consumer.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringMessageKafkaConsumer {

    @Value("${is-persist-string-message}")
    private Boolean isPersistMessage;

    @Autowired
    private MensagemService mensagemService;

    @KafkaListener(topics = "${topic-string-name}", groupId = "${group_id}")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);

        if(isPersistMessage) {
            MensagemEntity mensagemEntity = new MensagemEntity();
            mensagemEntity.setMensagem(message);

            mensagemService.save(mensagemEntity);
        }
    }


}
