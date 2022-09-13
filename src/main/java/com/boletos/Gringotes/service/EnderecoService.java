package com.boletos.Gringotes.service;


import com.boletos.Gringotes.model.EnderecoModel;
import com.boletos.Gringotes.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoModel> buscarTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> buscarId(Integer codigo) {
        return enderecoRepository.findById(codigo);
    }

    public EnderecoModel cadastrar(EnderecoModel endereco) {
        endereco.getCodigo();
        endereco.getLogradouro();
        endereco.getUsuario();
        return enderecoRepository.save(endereco);
    }

    public EnderecoModel alterar(EnderecoModel endereco, Integer codigo) {
        endereco.getCodigo();
        endereco.getLogradouro();
        endereco.getUsuario();

        return enderecoRepository.save(endereco);
    }

    public void deletar(Integer codigo) {
        enderecoRepository.deleteById(codigo);
    }
}

