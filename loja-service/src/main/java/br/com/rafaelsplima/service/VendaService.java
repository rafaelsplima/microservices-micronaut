package br.com.rafaelsplima.service;

import br.com.rafaelsplima.dto.input.VendaInput;
import br.com.rafaelsplima.dto.output.Parcela;
import br.com.rafaelsplima.dto.output.Veiculo;
import br.com.rafaelsplima.dto.output.Venda;
import br.com.rafaelsplima.producer.VendaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class VendaService {
    @Inject
    private VeiculoService veiculoService;

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private VendaProducer vendaProducer;

    public Venda realizaVenda(VendaInput vendaInput) throws JsonProcessingException {
        Veiculo veiculo;
        veiculo = veiculoService.getVeiculo(vendaInput.getVeiculo());
        List<Parcela> parcelas = new ArrayList<Parcela>();
        BigDecimal valorParcela = vendaInput.getValor().divide(new BigDecimal(vendaInput.getQuantidadeParcelas()));
        LocalDate dataVencimento = LocalDate.now().plusMonths(1);

        for (int i = 0; i < vendaInput.getQuantidadeParcelas(); i++) {
            Parcela parcela = new Parcela(valorParcela, dataVencimento.toString());
            parcelas.add(parcela);
            dataVencimento = dataVencimento.plusMonths(1);
        }

        Venda venda = new Venda(vendaInput.getCliente(), veiculo, vendaInput.getValor(), parcelas);

        confirmarVenda(venda);

        return venda;
    }
    @Produces
    public void confirmarVenda(Venda venda) throws JsonProcessingException {
        String vendaJSON = objectMapper.writeValueAsString(venda);

        vendaProducer.publicarVenda(UUID.randomUUID().toString(),vendaJSON, "Header");
    }
}
