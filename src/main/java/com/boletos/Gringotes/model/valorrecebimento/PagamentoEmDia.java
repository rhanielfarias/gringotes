package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public class PagamentoEmDia implements CalculoRecebimento {
    @Override
    public BigDecimal calculoPagamento(BigDecimal valorRecebido) {
        return valorRecebido;

    }

}