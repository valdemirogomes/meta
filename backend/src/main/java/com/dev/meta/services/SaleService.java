package com.dev.meta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.meta.entities.Sale;
import com.dev.meta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public Page<Sale> findSales(
			String minDate, 
			String maxDate, 
			Pageable pegeable) {
		
		//Pegando data atual	
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		//Convertendo data minima e data maxima de String para LocalDate
		LocalDate min = minDate.equals("") ? today.minusMonths(365): LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today: LocalDate.parse(maxDate);
		
		
		return repository.findSales(min, max, pegeable);
		
	}

}
