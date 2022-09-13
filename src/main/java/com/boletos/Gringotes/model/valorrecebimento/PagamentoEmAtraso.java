package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.enums.RecebimentoAlugueis;
import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public class PagamentoEmAtraso implements CalculoRecebimento {
    @Override
    public BigDecimal calculoPagamento(ContasReceberModel contasReceberModel) {
        return contasReceberModel.getValorRecebido().add(contasReceberModel.getValorRecebido().multiply(new BigDecimal("0.035")));
    }
}
