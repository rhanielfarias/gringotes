package com.boletos.Gringotes.model.dto;

import com.boletos.Gringotes.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDto {
    private Integer codigo;
    private String nomeUsuario;
    private LocalDate dataDeNascimento;
    private String email;

    public UsuarioDto(UsuarioModel usuarioModel) {
        this.codigo = usuarioModel.getCodigo();
        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.dataDeNascimento = usuarioModel.getDataNascimento();
        this.email = usuarioModel.getEmail();
    }

    public static List<UsuarioDto> converter(List<UsuarioModel> usuarioModels) {
        return usuarioModels.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
