export interface CepModel {
    cep: string;
    logradouroCompleto: string;
    uf: string;
    bairro: string;
    latitude: string;
    longitude: string;
    cidade: string;
    ddd: string;
}

export interface ClimaModel {
    data: string;
    temperatura: number;
    sensacaoTermica: number;
    condicaoClimatica: number;
    velocidadeVento: number;
}

export interface CepClimaResponse {
    cep: CepModel;
    clima: ClimaModel;
}
