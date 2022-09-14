package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public class PagamentoEmAtraso implements CalculoRecebimento {
    @Override
    public BigDecimal calculoPagamento(BigDecimal valorRecebido) {
        BigDecimal aplicarAtraso = valorRecebido.multiply(new BigDecimal("0.35"));
        BigDecimal valor = valorRecebido.add(aplicarAtraso);
        return valor;
    }

}
