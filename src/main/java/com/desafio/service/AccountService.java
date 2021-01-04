package com.desafio.service;

import com.desafio.config.validation.FormErrorDto;
import com.desafio.controller.dto.AccountDto;
import com.desafio.controller.form.AccountForm;
import com.desafio.model.Account;
import com.desafio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto save(AccountForm accountForm){
        Account account = accountForm.convert();
        accountRepository.save(account);
        return new AccountDto(account);
    }

    public List<FormErrorDto> checkCpfAndEmail(AccountForm accountForm){
        formatCpf(accountForm);

        List<FormErrorDto> formErrorDtos = new ArrayList<>();

        if(accountRepository.getAccountByCpf(accountForm.getCpf()) != null){
            formErrorDtos.add(new FormErrorDto("cpf","CPF already exists"));
        }
        if(accountRepository.getAccountByEmail(accountForm.getEmail()) != null){
            formErrorDtos.add(new FormErrorDto("e-mail","E-mail already exists"));
        }
        return formErrorDtos;
    }

    public void formatCpf(AccountForm accountForm){
        // Removes all non numeric characters from CPF
        accountForm.setCpf(accountForm.getCpf().replaceAll("[^\\d]", ""));
    }
}
