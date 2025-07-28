package com.vinisnzy.order_reader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DocumentListener {

    private static final Logger log = LoggerFactory.getLogger(DocumentListener.class);

    @KafkaListener(topics = "document-reader", groupId = "order_reader_group")
    public void onDocumentRead(String content) {
        log.info("Document read with content:");
        log.info(content);
    }
}
