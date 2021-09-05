package com.donmin.text.extractor.extractorTest.controller;

import com.donmin.text.extractor.extractorTest.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class RequestController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping("extractor/extract")
    public String extractTextFromImage(@RequestParam("file") MultipartFile file) throws IOException {
        return rabbitMQSender.send(file);
    }
}
