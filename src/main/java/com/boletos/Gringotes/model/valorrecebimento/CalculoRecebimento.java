package com.boletos.Gringotes.model.valorrecebimento;

import com.boletos.Gringotes.model.ContasReceberModel;

import java.math.BigDecimal;

public interface CalculoRecebimento {
    public BigDecimal calculoPagamento(ContasReceberModel contasReceberModel);

}
