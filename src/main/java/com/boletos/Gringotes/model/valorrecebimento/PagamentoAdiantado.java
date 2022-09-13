package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public class PagamentoAdiantado implements CalculoRecebimento {
    @Override
    public BigDecimal calculoPagamento(ContasReceberModel contasReceberModel) {
        return contasReceberModel.getValorRecebido().subtract(contasReceberModel.getValorRecebido()).multiply(new BigDecimal("0.05"));
    }

}
