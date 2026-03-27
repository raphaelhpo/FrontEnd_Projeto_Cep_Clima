package br.com.orati.cepclima.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orati.cepclima.model.Cep;

public interface CepRepository extends JpaRepository<Cep, UUID> {

}
