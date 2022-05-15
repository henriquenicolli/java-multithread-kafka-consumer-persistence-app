package com.kafka.broker.consumer.service;

import com.kafka.broker.consumer.model.MensagemEntity;
import com.kafka.broker.consumer.repository.MensagemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.CompletableFuture;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    Logger logger = LoggerFactory.getLogger(MensagemService.class);

    @Async
    @Transactional
    public CompletableFuture<MensagemEntity> save(MensagemEntity mensagem) {
        long start = System.currentTimeMillis();
        logger.info("saving message {}", mensagem.getMensagem(), "" + Thread.currentThread().getName());

        mensagemRepository.saveAndFlush(mensagem);

        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));

        return CompletableFuture.completedFuture(mensagem);
    }

}
