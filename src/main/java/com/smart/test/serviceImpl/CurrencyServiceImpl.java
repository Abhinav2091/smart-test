package com.smart.test.serviceImpl;

import com.smart.test.dao.CurrencyRepo;
import com.smart.test.model.Currency;
import com.smart.test.responseDTO.CurrencyResponseDTO;
import com.smart.test.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepo currencyRepo;

    @Override
    public List<CurrencyResponseDTO> getAllCurrency() {
        List<Currency> currencies = currencyRepo.findAll();
        List<CurrencyResponseDTO> currencyResponseDTOS = new ArrayList<>(currencies.size());
        for (Currency currency : currencies) {
            currencyResponseDTOS.add(new CurrencyResponseDTO(currency.getId(), currency.getName()));
        }
        return currencyResponseDTOS;
    }
}
