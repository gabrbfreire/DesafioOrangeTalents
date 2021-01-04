package com.desafio.service;

import com.desafio.controller.dto.AccountDto;
import com.desafio.controller.form.AccountForm;
import com.desafio.model.Account;
import com.desafio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto save(AccountForm accountForm){
        Account account = accountForm.convert();
        accountRepository.save(account);
        return new AccountDto(account);
    }
}
