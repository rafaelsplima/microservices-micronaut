package br.com.rafaelsplima.service;

import br.com.rafaelsplima.model.Veiculo;
import br.com.rafaelsplima.repository.VeiculoRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class VeiculoService {

    @Inject
    private VeiculoRepository veiculoRepository;

    public Veiculo create (Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).get();
    }
}
