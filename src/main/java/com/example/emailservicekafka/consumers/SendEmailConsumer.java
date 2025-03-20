package com.example.emailservicekafka.consumers;

import com.example.emailservicekafka.dtos.SendEmailDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendEmailConsumer {
    private ObjectMapper objectMapper;

    public SendEmailConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //@KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void consume(String message) throws Exception {
        SendEmailDto sendEmailDto = objectMapper.readValue(message, SendEmailDto.class);
        System.out.println("Received Email: " + sendEmailDto.getEmailId());
        System.out.println("Received message: " + sendEmailDto.getMessage());
    }
}
