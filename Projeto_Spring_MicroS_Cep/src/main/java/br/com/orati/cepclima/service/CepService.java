package br.com.orati.cepclima.service;

import org.springframework.stereotype.Service;

import br.com.orati.cepclima.exceptions.CepInvalidoException;
import br.com.orati.cepclima.exceptions.CepVazioException;
import br.com.orati.cepclima.model.Cep;
import br.com.orati.cepclima.model.DTOs.CreateCepDTO;
import br.com.orati.cepclima.model.DTOs.ResponseCepDTO;
import br.com.orati.cepclima.repository.CepRepository;
import br.com.orati.cepclima.service.API.CepApiService;
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
            Cep dadosCep = apiService.buscarDadosCep(cepDTO.cep());
            repository.save(dadosCep);
            if (cepDTO == null || cepDTO.cep() == null) {
                throw new CepVazioException("CEP Vazio.");
            }
            ResponseCepDTO response = new ResponseCepDTO(
                    dadosCep.getCep(),
                    dadosCep.getLatitude(),
                    dadosCep.getLongitude());
            return response;
        } catch (FeignException e) {
            throw new CepInvalidoException("CEP Inválido" + e);
        }
    }
}
