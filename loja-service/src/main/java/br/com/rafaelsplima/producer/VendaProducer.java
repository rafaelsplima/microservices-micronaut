package br.com.rafaelsplima.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.http.annotation.Header;

@KafkaClient
public interface VendaProducer {

    @Topic("ms-vendas")
    public void publicarVenda(@KafkaKey String id,String vendaJson, @Header("My-Header") String myHeader);
}

