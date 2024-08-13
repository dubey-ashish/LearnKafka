package com.enduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig
{

    //The topic subscribed is same as where the Producer produces
    //groupId is from the application.properties

    /*
    A group of consumers that work together to consume messages from Kafka topics.
    Each consumer in the group processes messages from a distinct subset of partitions,
    allowing the workload to be distributed among multiple consumers.
     */
    @KafkaListener(topics=Constants.LocationTopic,groupId =Constants.GroupID)
    public void updatedLocation (String value)
    {
        System.out.println(value);


    }

}
