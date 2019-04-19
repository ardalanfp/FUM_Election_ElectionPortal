package com.microservice.FumElection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "election object was not found in database")
public class ElectionNotFoundException extends RuntimeException{
}
