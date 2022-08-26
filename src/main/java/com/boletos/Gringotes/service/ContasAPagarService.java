package com.boletos.Gringotes.service;

import com.boletos.Gringotes.enums.Status;
import com.boletos.Gringotes.enums.Tipo;
import com.boletos.Gringotes.model.ContasAPagarModel;
import com.boletos.Gringotes.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarModel> findByTipo(Tipo tipo) {
        return contasAPagarRepository.findByTipo(tipo);
    }

    public List<ContasAPagarModel> findByStatus(Status status) {
        return contasAPagarRepository.findByStatus(status);
    }

    public Status validarData(LocalDate data) {
        LocalDate dataAtual = LocalDate.now();
        if (data.isBefore(dataAtual)) {
            return Status.VENCIDA;
        } else {
            return Status.AGUARDANDO;
        }
    }

    public List<ContasAPagarModel> buscarTodos() {
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscarId(Long codigo) {
        return contasAPagarRepository.findById(codigo);
    }

    public ContasAPagarModel cadastrar(ContasAPagarModel contasAPagarModel) {
        contasAPagarModel.setStatus(validarData(contasAPagarModel.getDataDeVencimento()));
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterar(ContasAPagarModel contas, Long codigo) {
        Optional<ContasAPagarModel> optionalContasAPagarModel = contasAPagarRepository.findById(codigo);
        if (optionalContasAPagarModel.isEmpty()) {
            throw new RuntimeException("Não foi encontrado no sistema essa conta. Tente outra, por favor");
        }
        ContasAPagarModel contaCarregada = optionalContasAPagarModel.get();
        Status statusInfo = contas.getStatus();
        contaCarregada.setStatus(statusInfo);

        return contasAPagarRepository.save(contaCarregada);
    }

    public void deletar(Long codigo) {
        contasAPagarRepository.deleteById(codigo);
    }
}
