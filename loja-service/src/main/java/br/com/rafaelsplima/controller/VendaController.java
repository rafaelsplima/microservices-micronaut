package br.com.rafaelsplima.controller;

import br.com.rafaelsplima.dto.input.VendaInput;
import br.com.rafaelsplima.service.VendaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/vendas")
public class VendaController {
    @Inject
    private VendaService vendaService;

    @Post
    public void realizaVenda(@Body VendaInput vendaInput) throws JsonProcessingException {

        vendaService.realizaVenda(vendaInput);
    }
}
