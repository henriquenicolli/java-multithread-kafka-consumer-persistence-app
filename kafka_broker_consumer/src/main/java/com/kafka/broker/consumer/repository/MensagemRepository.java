package com.kafka.broker.consumer.repository;

import com.kafka.broker.consumer.model.MensagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MensagemRepository extends JpaRepository<MensagemEntity, Long> {

}
