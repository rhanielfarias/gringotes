package com.boletos.Gringotes.service;

import com.boletos.Gringotes.model.UsuarioModel;
import com.boletos.Gringotes.model.dto.UsuarioDto;
import com.boletos.Gringotes.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    private UsuarioDto usuarioDto;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializador() {
        usuarioDto = new UsuarioDto(1, "Rhaniel Farias", LocalDate.now(), "rhanielfarias@gmail.com");
        usuarioModel = new UsuarioModel(1, "Rhaniel Farias", LocalDate.now(), "rhanielfarias@gmail.com", "022.850.650-60");
    }

    @Test
    void exibindoOsUsuariosCasoAListaEstejaVazia() {
        when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());
        List<UsuarioDto> todosOsUsuarios = usuarioService.buscarPorTodos();
        assertTrue(todosOsUsuarios.isEmpty());
    }

    @Test
    void exibindoUsuariosCasoExiste() {
        when(usuarioRepository.findAll()).thenReturn(List.of(usuarioModel));
        List<UsuarioDto> todosOsUsuarios = usuarioService.buscarPorTodos();
        assertFalse(todosOsUsuarios.isEmpty());
    }

    @Test
    void verificandoSeEstaSendoEfetuadoOCadastroDoUsuarioComIdNomeDataDeNascimentoEmailECpf() {
        when(usuarioRepository.existsById(anyInt())).thenReturn(false);
        usuarioService.cadastrar(usuarioModel);
        verify(usuarioRepository, times((1))).save(usuarioModel);
    }


    @Test
    void apresentandoErroCasoExistaUsuarioJaCadastrado() {
        when(usuarioRepository.existsById(1)).thenReturn(true);
        assertThrows(RuntimeException.class, () -> {
            usuarioService.cadastrar(usuarioModel);
        });
        verify(usuarioRepository, times(1)).existsById(1);

    }

}