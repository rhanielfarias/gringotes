package com.boletos.Gringotes.service;

import com.boletos.Gringotes.model.UsuarioModel;
import com.boletos.Gringotes.model.dto.UsuarioDto;
import com.boletos.Gringotes.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceTest {
    @Mock
    UsuarioService usuarioService;

    @MockBean
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
    void exibindoOsUsuarios() {
        List<UsuarioDto> todos = usuarioService.buscarPorTodos();
        assertTrue(todos.isEmpty());
    }

    @Test
    void verificandoSeEstaSendoEfetuadoOCadastroDoUsuarioComIdNomeDataDeNascimentoEmailECpf() {
        Mockito.when(usuarioRepository.existsById(Mockito.anyInt())).thenReturn(true);
        usuarioRepository.save(usuarioModel);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioModel);
    }

}