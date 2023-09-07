package com.smart.test.service;

import com.smart.test.model.Currency;
import com.smart.test.responseDTO.CurrencyResponseDTO;

import java.util.List;

public interface CurrencyService {

    List<CurrencyResponseDTO> getAllCurrency();
}
