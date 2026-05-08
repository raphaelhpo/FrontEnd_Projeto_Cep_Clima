package br.com.orati.cepclima.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.orati.cepclima.client.CepClientService;
import br.com.orati.cepclima.client.ClimaClientService;
import br.com.orati.cepclima.dto.create.CreateCepDTO;
import br.com.orati.cepclima.dto.create.CreateClimaDTO;
import br.com.orati.cepclima.dto.response.ResponseDTO;
import br.com.orati.cepclima.exceptions.CepInvalidoException;
import br.com.orati.cepclima.exceptions.CepVazioException;
import br.com.orati.cepclima.model.Cep;
import br.com.orati.cepclima.repository.CepRepository;
import feign.FeignException;

@Service

public class CepService {

    private final CepRepository repository;
    private final CepClientService cepClientService;
    private final ClimaClientService climaClientService;

    public CepService(CepRepository repository,
            CepClientService cepClientService,
            ClimaClientService climaClientService) {
        this.repository = repository;
        this.cepClientService = cepClientService;
        this.climaClientService = climaClientService;
    }

    // TODO: Criar Exception Expecífica para FeingException
    private CreateCepDTO buscarDadosCepApi(CreateCepDTO cepDTO) {
        return cepClientService.buscarDadosCep(cepDTO.getCep());
    }

    private CreateClimaDTO buscarDadosClimaApi(CreateCepDTO cepDTO) {
        return climaClientService.buscarDadosClima(Double.valueOf(cepDTO.getLatitude()),
                Double.valueOf(cepDTO.getLongitude()));
    }

    /**
     * 
     * @param cepDTO
     * @return
     */
    private Optional<Cep> buscarDadosCepDb(CreateCepDTO cepDTO) {
        return repository.findByCep(cepDTO.getCep());
    }

    /**
     * 
     * @param cep
     */
    private void salvarNoBanco(Cep cep) {
        repository.save(cep);
    }

    /**
     * 
     * @param cepDTO
     * @return
     */
    private CreateCepDTO validaCep(CreateCepDTO cepDTO) {
        if (cepDTO == null || cepDTO.getCep() == null) {
            throw new CepVazioException("CEP Vazio.");
        } else {
            return cepDTO;
        }
    }

    /**
     * 
     * @param cep
     * @return
     */
    private ResponseDTO mapperResponseDTO(CreateCepDTO cep, CreateClimaDTO clima) {
        return new ResponseDTO(cep, clima);
    }

    private CreateCepDTO mapperCreateCepDTO(Cep cep) {
        return new CreateCepDTO(
                cep.getCep(),
                cep.getLogradouroCompleto(),
                cep.getUf(),
                cep.getBairro(),
                cep.getLatitude(),
                cep.getLongitude(),
                cep.getCidade(),
                cep.getDdd());
    }

    /**
     * 
     * @param cepDTO
     * @return
     */
    public ResponseDTO create(String cep) {
        try {
            CreateCepDTO cepDTO = new CreateCepDTO();
            cepDTO.setCep(cep);
            validaCep(cepDTO);
            CreateCepDTO dadosCep = buscarDadosCepDb(cepDTO)
                    .map((cepObj) -> mapperCreateCepDTO(cepObj))
                    .orElseGet(() -> {
                        CreateCepDTO cepApi = buscarDadosCepApi(cepDTO);
                        salvarNoBanco(cepApi.toEntity());
                        return cepApi;
                    });
            return new ResponseDTO(dadosCep, buscarDadosClimaApi(dadosCep));
        } catch (FeignException e) {
            throw new CepInvalidoException("CEP Inválido\n" + e);
        }
    }

}
