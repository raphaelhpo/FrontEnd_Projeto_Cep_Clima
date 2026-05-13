export interface CepModel {
    cep: string;
    logradouro: string;
    bairro: string;
    latitude: string;
    longitude: string;
    CidadeModel: CidadeModel;
    EstadoModel: EstadoModel;
}

export interface CidadeModel {
    nome: string;
    ddd: string;
}

export interface EstadoModel {
    sigla: string;
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
