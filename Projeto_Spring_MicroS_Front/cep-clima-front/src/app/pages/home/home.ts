import { Component } from '@angular/core';
import { Header } from '../../components/header/header';
import { SearchBar } from '../../components/search-bar/search-bar';
import { AddressCard } from '../../components/address-card/address-card';
import { WeatherCard } from '../../components/weather-card/weather-card';
import { CepClimaResponse } from '../../models/cep-clima';

@Component({
  selector: 'app-home',
  imports: [Header, SearchBar, AddressCard, WeatherCard],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  resultado: CepClimaResponse | null = null;

  onResultado(data: CepClimaResponse) {
    this.resultado = data;
  }
}