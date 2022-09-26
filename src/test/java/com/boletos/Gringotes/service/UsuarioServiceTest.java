package com.boletos.Gringotes.service;

import com.boletos.Gringotes.model.UsuarioModel;
import com.boletos.Gringotes.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;


    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializador() {
        usuarioModel = new UsuarioModel(1, "Rhaniel Farias", LocalDate.now(), "rhanielfarias@gmail.com", "022.850.650-60");
    }

    @Test
    void verificandoSeEstaSendoEfetuadoOCadastroDoUsuarioComIdNomeDataDeNascimentoEmailECpf() {
        Optional.of()
        when(usuarioRepository.save(usuarioModel)).thenReturn(usuarioModel);
        usuarioService.cadastrar(usuarioModel);
        //verify(usuarioRepository, times(1)).existsById(usuarioModel.getCodigo());
        verify(usuarioRepository, times(1)).save(usuarioModel);
    }
}

