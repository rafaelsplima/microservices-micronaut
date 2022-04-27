package br.com.rafaelsplima.service;

import br.com.rafaelsplima.model.Venda;
import br.com.rafaelsplima.repository.VendasReopository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class VendaService {
    @Inject
    private VendasReopository vendasReopository;

    public void create (Venda venda) {
        vendasReopository.create(venda);
    }

    public List<Venda> getAll(){
        return vendasReopository.getAll();
    }
}
