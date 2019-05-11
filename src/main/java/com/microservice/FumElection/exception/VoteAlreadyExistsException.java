package com.microservice.FumElection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "user has already voted")
public class VoteAlreadyExistsException extends RuntimeException {
}
