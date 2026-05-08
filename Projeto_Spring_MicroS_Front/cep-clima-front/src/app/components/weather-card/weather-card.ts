import { Component, Input } from '@angular/core';
import { ClimaModel } from '../../models/cep-clima';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-weather-card',
  imports: [DatePipe],
  templateUrl: './weather-card.html',
  styleUrl: './weather-card.css',
})
export class WeatherCard {
  @Input() dados!: ClimaModel;
}