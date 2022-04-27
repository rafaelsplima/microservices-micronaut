package br.com.rafaelsplima.controller;

import br.com.rafaelsplima.model.Venda;
import br.com.rafaelsplima.service.VendaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/vendas")
public class VendaController {

    @Inject
    VendaService vendaService;

    @Get
    public List<Venda> getAll() {
        return vendaService.getAll();
    }
}
