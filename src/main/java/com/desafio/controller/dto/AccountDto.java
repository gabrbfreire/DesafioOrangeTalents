package com.desafio.controller.dto;

import com.desafio.model.Account;
import java.text.Format;
import java.text.SimpleDateFormat;

public class AccountDto {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String birthday;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.cpf = account.getCpf();

        //Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.birthday = account.getBirthday();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
