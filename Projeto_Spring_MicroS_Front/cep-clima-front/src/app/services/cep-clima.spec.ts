import { TestBed } from '@angular/core/testing';

import { CepClima } from './cep-clima';

describe('CepClima', () => {
  let service: CepClima;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CepClima);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
