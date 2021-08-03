package com.techprimers.kafka.springbootkafkaproducerexample.kafkaconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.techprimers.kafka.springbootkafkaproducerexample.model.User;



@Configuration
public class KafkaConfiguration {

    @Bean
    public ProducerFactory<String, User> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");//kafka server location 9092
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//key that we passing since kafkaTemplate<String, (User)Json>
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);//value serialization class, just like above key for 
                                                                                       //kafkaTemplate<StringSerializer,JsonSerializer>

        return new DefaultKafkaProducerFactory<>(config);// we can pass avro or Json format(in above case we passed Json, so Json serializer
        //passing kafka server port, key, value in config
    }


    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());//we injecting above producerFactory() into this KafkaTemlate, so that we can use in publising message in UserResource controller class
    }


}
