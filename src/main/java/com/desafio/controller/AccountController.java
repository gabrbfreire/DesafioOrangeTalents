package com.desafio.controller;

import com.desafio.controller.dto.AccountDto;
import com.desafio.controller.form.AccountForm;
import com.desafio.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createNewClient(@RequestBody AccountForm accountForm, UriComponentsBuilder uriBuilder){
        AccountDto accountDto = accountService.save(accountForm);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(accountDto.getId()).toUri();
        return ResponseEntity.created(uri).body(accountDto);
    }
}
