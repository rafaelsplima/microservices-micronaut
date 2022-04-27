package br.com.rafaelsplima.model;

import java.math.BigDecimal;

public class Parcela {
    private BigDecimal valor;
    private String dataVencimento;

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
