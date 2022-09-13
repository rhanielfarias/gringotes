package com.boletos.Gringotes.controller;


import com.boletos.Gringotes.model.EnderecoModel;
import com.boletos.Gringotes.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/endereco")
    public ResponseEntity<List<EnderecoModel>> buscarPorEndereco() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping(path = "/endereco/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> buscarId(@PathVariable Integer codigo) {
        return ResponseEntity.ok(enderecoService.buscarId(codigo));
    }

    @PostMapping(path = "/endereco")
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody EnderecoModel enderecoModel) {
        EnderecoModel endereco = enderecoService.cadastrar(enderecoModel);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @PutMapping(path = "/endereco/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@RequestBody EnderecoModel enderecoModel, @PathVariable Integer codigo) {
        return ResponseEntity.ok(enderecoService.alterar(enderecoModel, codigo));
    }

    @DeleteMapping(path = "/endereco/{codigo}")
    public void deletar(@PathVariable Integer codigo) {
        enderecoService.deletar(codigo);


    }
}
