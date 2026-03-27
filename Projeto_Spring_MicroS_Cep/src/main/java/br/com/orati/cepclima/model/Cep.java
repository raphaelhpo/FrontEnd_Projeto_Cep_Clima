package br.com.orati.cepclima.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
{
  "cep": "03069030",
  "address_type": "Rua",
  "address_name": "Coronel Gustavo Santiago",
  "address": "Rua Coronel Gustavo Santiago",
  "state": "SP",
  "district": "Vila Zilda ",
  "lat": "-23.5350651",
  "lng": "-46.5652125",
  "city": "São Paulo",
  "city_ibge": "3550308",
  "ddd": "11"
}
*/

@Entity(name = "DataCep")
@Getter
@NoArgsConstructor
public class Cep {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;
  String cep;
  @JsonProperty("address")
  String logradouroCompleto;
  @JsonProperty("state")
  String uf;
  @JsonProperty("district")
  String bairro;
  @JsonProperty("lat")
  String latitude;
  @JsonProperty("lng")
  String longitude;
  @JsonProperty("city")
  String cidade;
  String ddd;
}
