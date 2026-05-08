package br.com.orati.cepclima.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.orati.cepclima.client.ClimaApiService;
import br.com.orati.cepclima.dto.CreateClimaDTO;
import br.com.orati.cepclima.dto.CreateCoordenadasDTO;
import br.com.orati.cepclima.model.Clima;
import br.com.orati.cepclima.repository.ClimaRepository;

@Service
public class ClimaService {

    ClimaApiService clientService;
    ClimaRepository repository;

    private ClimaService(ClimaApiService service, ClimaRepository repository) {
        this.repository = repository;
        this.clientService = service;
    }

    // TODO: Incluir tratamento de erros com Exception
    // [ ]: Buscar por lat,long e data se já foi feita a consulta no DB
    public Optional<Clima> buscarClimaExistente(UUID id) {
        return repository.findById(id);
    }

    // TODO: Incluir tratamento de erros com Exception
    public Clima salvarClima(Clima clima) {
        return repository.save(clima);
    }

    // TODO: Incluir tratamento de erros com Exception
    // TODO: Incluir lógica para salvar dados no banco
    // TODO: Incluir lógica de busca de dados no banco antes de chamar o client
    public CreateClimaDTO buscarDadosClient(CreateCoordenadasDTO coordenadasDTO) {
        CreateClimaDTO reponseClimaClient = clientService.buscarDadosClima(
                coordenadasDTO.latitude().toString(),
                coordenadasDTO.longitude().toString());

        return reponseClimaClient;
    }

}
