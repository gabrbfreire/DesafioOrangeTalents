package com.desafio.controller.form;

import com.desafio.model.Account;
import com.sun.istack.NotNull;
import org.apache.commons.validator.GenericValidator;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AccountForm {

    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty @CPF
    private String cpf;
    @NotNull @NotEmpty
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

    public Account convert() throws MethodArgumentNotValidException {
        if(GenericValidator.isDate(birthday, "dd/MM/yyyy", true)){
            return new Account(name, email, cpf, birthday);
        }
        throw new MethodArgumentNotValidException(null, new BindException(new Object(),""));
    }
}