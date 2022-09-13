package com.boletos.Gringotes.model.valorrecebimento;


public class EfetuarRecebimento {

    public CalculoRecebimento tipoRecebimento(String tipoRecebimento) {
        if (tipoRecebimento.equalsIgnoreCase("EM_ATRASO")) {
            return new PagamentoEmAtraso();
        } else if (tipoRecebimento.equalsIgnoreCase("ADIANTADO")) {
            return new PagamentoAdiantado();
        } else if (tipoRecebimento.equalsIgnoreCase("EM_DIA")) {
            return new PagamentoEmDia();
        } else {
            return null;
        }

    }

}


