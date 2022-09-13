package com.boletos.Gringotes.service;


import com.boletos.Gringotes.model.CidadeModel;
import com.boletos.Gringotes.repository.CidadeRepository;
import com.boletos.Gringotes.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<CidadeModel> buscarPorTodos() {
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarId(Integer codigo) {
        return cidadeRepository.findById(codigo);
    }

    public CidadeModel cadastrar(CidadeModel cidadeModel) {
        cidadeModel.getCodigo();
        cidadeModel.getCidades();
        cidadeModel.getEstadoModel();

        return cidadeRepository.save(cidadeModel);
    }

    public CidadeModel alterar(CidadeModel cidadeModel, Integer codigo) {
        cidadeModel.getCodigo();
        cidadeModel.getCidades();
        cidadeModel.getEstadoModel();
        return cidadeRepository.save(cidadeModel);
    }

    public void deletar(Integer codigo) {
        cidadeRepository.deleteById(codigo);
    }


}

