package com.desafio.controller.form;

import com.desafio.model.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

public class AccountForm {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty @CPF
    private String cpf;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Account convert() {
        return new Account(name, email, cpf, birthday);
    }
}
