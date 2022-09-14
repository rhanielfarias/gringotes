package com.boletos.Gringotes.model.valorrecebimento;


import com.boletos.Gringotes.enums.RecebimentoAlugueis;
import com.boletos.Gringotes.model.ContasReceberModel;

public class EfetuarRecebimento {

    public CalculoRecebimento tipoRecebimento(ContasReceberModel contasReceberModel) {
        if (contasReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.EM_ATRASO)) {
            return new PagamentoEmAtraso();
        } else if (contasReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.ADIANTADO)) {
            return new PagamentoAdiantado();
        } else if (contasReceberModel.getRecebimentoAlugueis().equals(RecebimentoAlugueis.EM_DIA)) {
            return new PagamentoEmDia();
        } else {
            return null;
        }

    }

}


