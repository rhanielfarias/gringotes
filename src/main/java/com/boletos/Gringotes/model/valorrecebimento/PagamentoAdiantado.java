package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public class PagamentoAdiantado implements CalculoRecebimento {
    @Override
    public BigDecimal calculoPagamento(BigDecimal valorRecebido) {
        BigDecimal aplicarDesconto = valorRecebido.multiply(new BigDecimal(0.05));
        BigDecimal valor = valorRecebido.subtract(aplicarDesconto);
        return valor;


    }

}