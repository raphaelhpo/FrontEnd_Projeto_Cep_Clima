package br.com.orati.cepclima.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orati.cepclima.model.Clima;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, UUID> {
}
