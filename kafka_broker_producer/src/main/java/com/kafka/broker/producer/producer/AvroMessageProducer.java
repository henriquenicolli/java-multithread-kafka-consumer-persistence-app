package com.kafka.broker.producer.producer;

import com.kafka.teste.schema.Employee;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class AvroMessageProducer {

    @Value("${topic-avro-name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, GenericRecord> generickafkaTemplate;

    public void sendAvro() {
        Employee employee = Employee.newBuilder()
                .setId(1)
                .setFirstName("teste")
                .setLastName("teste")
                .build();

        ListenableFuture<SendResult<String, GenericRecord>> future =
                generickafkaTemplate.send(topicName, employee);

        future.addCallback(new ListenableFutureCallback<SendResult<String, GenericRecord>>() {

            @Override
            public void onSuccess(SendResult<String, GenericRecord> result) {
                System.out.println("Sent message=[" + result +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }


}
