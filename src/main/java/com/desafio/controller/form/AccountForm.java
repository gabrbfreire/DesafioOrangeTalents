package com.desafio.controller.form;

import com.desafio.model.Account;

public class AccountForm {

    private String name;
    private String email;
    private String cpf;
    private String birthday;

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

    public Account convert() {
        return new Account(name, email, cpf, birthday);
    }
}
