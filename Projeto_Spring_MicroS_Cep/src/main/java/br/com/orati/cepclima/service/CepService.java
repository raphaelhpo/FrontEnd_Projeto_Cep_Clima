package br.com.orati.cepclima.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.orati.cepclima.client.CepApiService;
import br.com.orati.cepclima.exceptions.CepInvalidoException;
import br.com.orati.cepclima.exceptions.CepVazioException;
import br.com.orati.cepclima.model.Cep;
import br.com.orati.cepclima.model.DTOs.CreateCepDTO;
import br.com.orati.cepclima.model.DTOs.ResponseCepDTO;
import br.com.orati.cepclima.repository.CepRepository;
import feign.FeignException;

@Service

public class CepService {

    public final CepRepository repository;
    public final CepApiService apiService;

    public CepService(CepRepository repository, CepApiService apiService) {
        this.repository = repository;
        this.apiService = apiService;
    }

    /**
     * 
     * @param cepDTO
     * @return
     */
    public ResponseCepDTO create(CreateCepDTO cepDTO) {
        try {
            Cep dadosCepApi = apiService.buscarDadosCep(cepDTO.cep());
            Optional<Cep> PosiveisDadosCepDb = repository.findByCep(cepDTO.cep());
            ResponseCepDTO response = new ResponseCepDTO();
            if (PosiveisDadosCepDb.isEmpty()) {
                repository.save(dadosCepApi);
                response.setCep(dadosCepApi.getCep());
                response.setLatitude(dadosCepApi.getLatitude());
                response.setLongitude(dadosCepApi.getLongitude());
            } else {
                Cep dadosCepDb = PosiveisDadosCepDb.get();
                response.setCep(dadosCepDb.getCep());
                response.setLatitude(dadosCepDb.getLatitude());
                response.setLongitude(dadosCepDb.getLongitude());
            }
            if (cepDTO == null || cepDTO.cep() == null) {
                throw new CepVazioException("CEP Vazio.");
            }
            return response;
        } catch (FeignException e) {
            throw new CepInvalidoException("CEP Inválido" + e);
        }
    }
}
