package com.boletos.Gringotes.service;


import com.boletos.Gringotes.model.UsuarioModel;
import com.boletos.Gringotes.model.dto.UsuarioDto;
import com.boletos.Gringotes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> buscarPorTodos() {
        List<UsuarioModel> buscarPorTodos = usuarioRepository.findAll();
        return UsuarioDto.converter(buscarPorTodos);
    }

    public Optional<UsuarioModel> buscarId(Integer codigo) {
        return usuarioRepository.findById(codigo);
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        usuarioModel.getCodigo();
        usuarioModel.getNomeUsuario();
        usuarioModel.getDataNascimento();
        usuarioModel.getEmail();
        usuarioModel.getCpf();

        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alterar(UsuarioModel usuario, Integer codigo) {
        usuario.getCodigo();
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer codigo) {
        usuarioRepository.deleteById(codigo);
    }
}
