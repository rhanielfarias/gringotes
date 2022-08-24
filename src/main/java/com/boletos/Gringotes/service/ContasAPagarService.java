package com.boletos.Gringotes.service;

import com.boletos.Gringotes.model.ContasAPagarModel;
import com.boletos.Gringotes.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {
    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public List<ContasAPagarModel> buscarTodos() {
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscarId(Long codigo) {
        return contasAPagarRepository.findById(codigo);
    }

    public ContasAPagarModel cadastrar(ContasAPagarModel contasAPagarModel) {
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterar(ContasAPagarModel contas) {
        return contasAPagarRepository.save(contas);
    }

    public void deletar(Long codigo) {
        contasAPagarRepository.deleteById(codigo);
    }
}
