package com.dev.meta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.meta.entities.Sale;
import com.dev.meta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public List<Sale> findSales() {		
		return repository.findAll();
		
	}

}
