package br.com.rafaelsplima.model;

import java.math.BigDecimal;
import java.util.List;

public class Venda {
    private String cliente;
    private Veiculo veiculo;
    private BigDecimal valorVenda;
    private List<Parcela> parcelas;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente='" + cliente + '\'' +
                ", veiculo=" + veiculo +
                ", valor=" + valorVenda +
                ", parcelas=" + parcelas +
                '}';
    }
}
