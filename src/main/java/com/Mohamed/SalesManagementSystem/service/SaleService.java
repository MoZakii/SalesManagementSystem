package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Sale;
import com.Mohamed.SalesManagementSystem.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    public Sale createSale(Sale sale){
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale updateSale){
        Optional<Sale> sale1 = saleRepository.findById(id);
        if(sale1.isPresent()){
            updateSale.setId(id);
            saleRepository.save(updateSale);
        }
        return null;
    }

    public List<Sale> getSalesBetweenDates(LocalDate startDate, LocalDate endDate){
        List<Sale> allSales = saleRepository.findAll();
        List<Sale> chosenSales = new ArrayList<>();

        for (Sale currentSale : allSales) {
            if (currentSale.getCreationDate().compareTo(startDate) >= 0 && currentSale.getCreationDate().compareTo(endDate) <= 0)
                chosenSales.add(currentSale);
        }

        return chosenSales;
    }


}
