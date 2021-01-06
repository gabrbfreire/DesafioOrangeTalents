package com.desafio.service;

import com.desafio.config.validation.FormErrorDto;
import com.desafio.controller.dto.AccountDto;
import com.desafio.controller.form.AccountForm;
import com.desafio.model.Account;
import com.desafio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto save(AccountForm accountForm) throws MethodArgumentNotValidException {
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

    private void formatCpf(AccountForm accountForm){
        // Removes all non numeric characters from CPF
        accountForm.setCpf(accountForm.getCpf().replaceAll("[^\\d]", ""));
    }

    public AccountDto getAccountById(Long id){
        Optional<Account> optionalAccount= accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            return new AccountDto(optionalAccount.get());
        }
        return null;
    }

    public List<AccountDto> getAllAccounts(){
        List<Account> accountList = accountRepository.findAll();
        List<AccountDto> accountDtos  = new ArrayList<>();

        accountList.forEach(account -> {
            accountDtos.add(new AccountDto(account));
        });
        return accountDtos;
    }
}
