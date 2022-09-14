package com.boletos.Gringotes.service;

import com.boletos.Gringotes.enums.RecebimentoAlugueis;
import com.boletos.Gringotes.enums.TipoRecebimento;
import com.boletos.Gringotes.model.ContasReceberModel;
import com.boletos.Gringotes.model.valorrecebimento.EfetuarRecebimento;
import com.boletos.Gringotes.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaReceberService {
    @Autowired
    private ContasReceberRepository contasReceberRepository;


    public List<ContasReceberModel> buscarTodos() {
        return contasReceberRepository.findAll();
    }

    public Optional<ContasReceberModel> buscarId(Integer codigo) {
        return contasReceberRepository.findById(codigo);
    }

    public ContasReceberModel cadastrar(ContasReceberModel contasReceberModel, EfetuarRecebimento efetuarRecebimento) {
        if (contasReceberModel.getTipoRecebimento().equals(TipoRecebimento.ALUGUEIS)) {
            boolean vencimentoDeHoje = LocalDate.now().isEqual(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
            boolean atrasado = LocalDate.now().isAfter(contasReceberModel.getDataDeVencimento());
            if (atrasado) {
                contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_ATRASO);
            } else if (vencimentoDeHoje) {
                contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_DIA);
            } else {
                contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.ADIANTADO);
            }
            BigDecimal valor = efetuarRecebimento.tipoRecebimento(contasReceberModel).calculoPagamento(contasReceberModel.getValorRecebido());
            contasReceberModel.setValorTotal(valor);
        }
        return contasReceberRepository.save(contasReceberModel);
    }

    public ContasReceberModel alterar(ContasReceberModel contas, Integer codigo) {
        Optional<ContasReceberModel> optionalContasReceberModel = contasReceberRepository.findById(codigo);
        if (optionalContasReceberModel.isEmpty()) {
            throw new RuntimeException("Não foi encontrado no sistema essa conta. Tente outra, por favor");
        }
        ContasReceberModel contaCarregada = optionalContasReceberModel.get();

        return contasReceberRepository.save(contaCarregada);
    }

    public void deletar(Integer codigo) {
        contasReceberRepository.deleteById(codigo);
    }

}
