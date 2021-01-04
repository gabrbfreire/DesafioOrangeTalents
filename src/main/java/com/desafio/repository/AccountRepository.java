package com.desafio.repository;

import com.desafio.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getAccountByCpf(String cpf);

    Account getAccountByEmail(String email);
}
