package com.boletos.Gringotes.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {
    private final  String mensagem;
    private  final  String field;
    private  final  Object parameter;


}
