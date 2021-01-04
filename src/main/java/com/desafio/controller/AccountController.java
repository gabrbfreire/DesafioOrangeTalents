package com.desafio.controller;

import com.desafio.config.validation.FormErrorDto;
import com.desafio.controller.dto.AccountDto;
import com.desafio.controller.form.AccountForm;
import com.desafio.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity createNewClient(@RequestBody @Valid AccountForm accountForm, UriComponentsBuilder uriBuilder){
        List<FormErrorDto> formErrorDtos = accountService.checkCpfAndEmail(accountForm);

        if(formErrorDtos.isEmpty()){ //If formErrorDtos is empty the are no duplicate CPFs or Emails
            AccountDto accountDto = accountService.save(accountForm);
            URI uri = uriBuilder.path("/client/{id}").buildAndExpand(accountDto.getId()).toUri();
            return ResponseEntity.created(uri).body(accountDto);
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(formErrorDtos);
        }
    }
}
