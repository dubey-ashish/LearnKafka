package com.deliveryboy.deliveryboy.service;

import com.deliveryboy.deliveryboy.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/*
Service Components are the class file which contains @Service annotation.
These class files are used to write business logic in a different layer,
separated from @RestController class file.
 */
@Service
public class KafkaService
{
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /*

    Key:
    The key is used to identify the partition within a Kafka topic to which the message should be sent.
    Kafka uses the key to ensure that all messages with the same key are sent to the same partition,
    which helps with message ordering.

    Value:
    The value is the actual data or payload of the message.
    This is the main content that you want to transmit to Kafka consumers.

     */
    public boolean updateLocation (String location)
    {
        this.kafkaTemplate.send(Constants.Location_Topic_Name,location);
        return true;
    }
}
