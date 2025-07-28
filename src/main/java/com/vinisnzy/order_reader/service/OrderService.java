package com.vinisnzy.order_reader.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OrderService {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public OrderService(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createOrder(MultipartFile pdf) {
        byte[] pdfBytes;
        try {
            pdfBytes = pdf.getBytes();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to read PDF: " + e.getMessage());
        }
        kafkaTemplate.send("document-order", pdfBytes);
    }
}
