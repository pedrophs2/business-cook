package com.arpdevs.businesscook.builders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder<E> {

    E response;

    public ResponseBuilder() {
        super();
    }

    public ResponseBuilder(E response) {
        super();
        this.response = response;
    }

    public ResponseEntity<?> ok() {
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<?> created() {
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<?> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    public ResponseEntity<?> internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no processo de requisição dos dados");
    }

}
