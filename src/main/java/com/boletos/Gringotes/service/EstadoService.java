package com.boletos.Gringotes.service;


import com.boletos.Gringotes.model.EstadoModel;
import com.boletos.Gringotes.repository.CidadeRepository;
import com.boletos.Gringotes.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<EstadoModel> buscarPorTodos() {
        return estadoRepository.findAll();
    }

    public Optional<EstadoModel> buscarId(Integer codigo) {
        return estadoRepository.findById(codigo);
    }

    public EstadoModel cadastrar(EstadoModel estadoModel) {
        estadoModel.getCodigo();
        estadoModel.getNomeDoEstado();
        return estadoRepository.save(estadoModel);
    }

    public EstadoModel alterar(EstadoModel estadoModel, Integer codigo) {
        estadoModel.getCodigo();
        estadoModel.getNomeDoEstado();
        return estadoRepository.save(estadoModel);
    }

    public void deletar(Integer codigo) {
        estadoRepository.deleteById(codigo);
    }

}
