package br.com.rafaelsplima.controller;

import br.com.rafaelsplima.model.Veiculo;
import br.com.rafaelsplima.service.VeiculoService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/veiculos")
public class VeiculoController {

    @Inject
    private VeiculoService veiculoService;

    @Post
    public HttpResponse<Veiculo> create(@Body Veiculo veiculo) {
        return HttpResponse.created(veiculoService.create(veiculo));
    }

    @Get("/{id}")
    public Veiculo getById(@PathVariable Long id) {
        return veiculoService.findById(id);
    }
}
