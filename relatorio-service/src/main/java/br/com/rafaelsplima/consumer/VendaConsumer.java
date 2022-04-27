package br.com.rafaelsplima.consumer;


import br.com.rafaelsplima.model.Venda;
import br.com.rafaelsplima.service.VendaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class VendaConsumer {
    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private VendaService vendaService;

    @Topic("ms-vendas")
    public void receberVenda(String id, String vendaJSON) throws JsonProcessingException {
        Venda venda = objectMapper.readValue(vendaJSON, Venda.class);
        vendaService.create(venda);
        System.out.println("Venda consumida " + venda);

    }
}
