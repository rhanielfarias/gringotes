package com.boletos.Gringotes.service;

import com.boletos.Gringotes.model.UsuarioModel;
import com.boletos.Gringotes.model.dto.UsuarioDto;
import com.boletos.Gringotes.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @InjectMocks
    UsuarioService usuarioService;

    UsuarioRepository usuarioRepository;

    private UsuarioDto usuarioDto;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializador() {
        MockitoAnnotations.openMocks(this);
        usuarioDto = new UsuarioDto(1, "Rhaniel Farias", LocalDate.now(), "rhanielfarias@gmail.com");
        usuarioModel = new UsuarioModel(1, "Rhaniel Farias", LocalDate.now(), "rhanielfarias@gmail.com", "022.850.650-60");
    }

    @Test
    void exibindoOsUsuariosCasoAListaEstejaVazia() {
        Mockito.when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());
        List<UsuarioDto> todosOsUsuarios = usuarioService.buscarPorTodos();
        Assertions.assertTrue(todosOsUsuarios.isEmpty());
    }

    @Test
    void verificandoSeEstaSendoEfetuadoOCadastroDoUsuarioComIdNomeDataDeNascimentoEmailECpf() {
        Mockito.when(usuarioRepository.existsById(Mockito.anyInt())).thenReturn(true);
        usuarioRepository.save(usuarioModel);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioModel);
    }

    @Test
    void verificandoSeOAlterarDoUsuarioEstaFuncionando() {
    }
rrrm
}