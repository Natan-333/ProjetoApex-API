package br.com.fiap.ApexInvest.repository;

import br.com.fiap.ApexInvest.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository <Conta, Long> {
}
