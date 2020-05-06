package com.qa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This Sector Does Not Exist")
public class SectorNotFoundException extends EntityNotFoundException {

}
