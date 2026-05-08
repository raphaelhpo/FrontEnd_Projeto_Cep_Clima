import { Component, Input } from '@angular/core';
import { CepModel } from '../../models/cep-clima';

@Component({
  selector: 'app-address-card',
  imports: [],
  templateUrl: './address-card.html',
  styleUrl: './address-card.css',
})
export class AddressCard {
  @Input() dados!: CepModel;
}