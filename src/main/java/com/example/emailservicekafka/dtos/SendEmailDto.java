package com.example.emailservicekafka.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailDto {
    private String emailId;
    private String message;
}
