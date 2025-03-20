package com.example.emailservicekafka.controllers;


import com.example.emailservicekafka.dtos.SendEmailDto;
import com.example.emailservicekafka.producers.SendEmailProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 kafka-topics.sh --create \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 --partitions 1 \
  --topic sendEmail

 */
@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private final SendEmailProducer sendEmailProducer;

    public EmailController(SendEmailProducer sendEmailProducer) {
        this.sendEmailProducer = sendEmailProducer;
    }
    @PostMapping("/send")
    public String sendEmail(@RequestBody SendEmailDto message) throws JsonProcessingException {
        return sendEmailProducer.sendEmail(message);
    }
}