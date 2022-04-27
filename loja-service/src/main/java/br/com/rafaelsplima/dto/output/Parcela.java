package br.com.rafaelsplima.dto.output;

import java.math.BigDecimal;

public class Parcela {

    private BigDecimal valor;
    private String dataVencimento;

    public Parcela() {}

    public Parcela(BigDecimal valor, String dataVencimento) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "valor=" + valor +
                ", dataVencimento='" + dataVencimento + '\'' +
                '}';
    }
}
