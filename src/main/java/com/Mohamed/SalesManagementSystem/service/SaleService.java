package com.Mohamed.SalesManagementSystem.service;

import com.Mohamed.SalesManagementSystem.model.Client;
import com.Mohamed.SalesManagementSystem.model.Sale;
import com.Mohamed.SalesManagementSystem.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    public void createSale(Sale sale){
        saleRepository.save(sale);
    }

    public void updateSale(Long id, Sale updateSale){
        Optional<Sale> sale1 = saleRepository.findById(id);
        if(sale1.isPresent()){
            Sale oldSale = sale1.get();
            oldSale.setClient(updateSale.getClient());
            oldSale.setSeller(updateSale.getSeller());
            oldSale.setTotal(updateSale.getTotal());
            saleRepository.save(oldSale);
        }
    }


}
