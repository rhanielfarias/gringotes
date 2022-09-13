package com.boletos.Gringotes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 300, nullable = false)
    private String logradouro;

    @Column(length = 300, nullable = false)
    private String bairro;

    @Column(length = 9, nullable = false)
    private String cep;

    @Column(length = 300, nullable = false)
    private String pontoReferencia;

@ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private  UsuarioModel usuario;

@ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
private  CidadeModel cidadeModel;
}
