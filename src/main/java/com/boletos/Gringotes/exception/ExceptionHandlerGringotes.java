package com.boletos.Gringotes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerGringotes extends ResponseEntityExceptionHandler {
    @Autowired
    MessageSource messageSource;

    @Override
            protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> erros = getErros(ex);
        ErrorResponse errorResponse = getErroResponse(ex, status, erros);
        return new ResponseEntity<>(errorResponse, status);
    }

    private  ErrorResponse getErroResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errorObjects) {
        return  new ErrorResponse("Requisição possui campo inválido. Faça outra, por favor", status.value(), status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errorObjects);

    }
    private  List<ErrorObject> getErros(MethodArgumentNotValidException ex){
        return  ex.getBindingResult().getFieldErrors().stream().map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue())).collect(Collectors.toList());

    }

        @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro {
        private String mensagemDoUsuario;
        private String mensagemDoDev;



}

}
