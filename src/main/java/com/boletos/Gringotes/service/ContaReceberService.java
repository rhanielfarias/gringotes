package com.boletos.Gringotes.service;

import com.boletos.Gringotes.enums.RecebimentoAlugueis;
import com.boletos.Gringotes.model.ContasReceberModel;
import com.boletos.Gringotes.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ContasReceberModel cadastrar(ContasReceberModel contasReceberModel) {
        boolean recebendoDataAtual = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(recebendoDataAtual)) {
            contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_ATRASO);
        } else if (Boolean.TRUE.equals(recebendoDataAtual)) {
            contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.EM_DIA);
        } else {
            contasReceberModel.setRecebimentoAlugueis(RecebimentoAlugueis.ADIANTADO);

        }
        return contasReceberRepository.save(contasReceberModel);
    }

    public ContasReceberModel alterar(ContasReceberModel contas, Integer codigo) {
        return contasReceberRepository.save(contas);
    }

    public void deletar(Integer codigo) {
        contasReceberRepository.deleteById(codigo);
    }

}
