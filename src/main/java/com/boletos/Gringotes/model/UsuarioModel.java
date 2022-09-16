package com.boletos.Gringotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
@NotBlank(message = "name.not.blank")
    private String nomeUsuario;

    @Column(length = 50, nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "not.blank.email")
    @Email(message = "email.not.valid")
    private String email;

    @NotBlank(message = "not.blank.cpf")
    @CPF
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContasReceberModel> contasReceberModel;
}
