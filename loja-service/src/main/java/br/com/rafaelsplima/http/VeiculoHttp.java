package br.com.rafaelsplima.http;

import br.com.rafaelsplima.dto.output.Veiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;

@Client(id = "veiculo-service")
@CircuitBreaker
public interface VeiculoHttp {
    @Get("/veiculos/{id}")
    public Veiculo getById(@PathVariable Long id) throws JsonProcessingException;
}
