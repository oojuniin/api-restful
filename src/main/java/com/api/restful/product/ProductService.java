package com.api.restful.product;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Product save(Product stock) {
		Product prod = new Product();

		if (repository.findById(stock.getId()).isPresent()) {

			prod.setId(stock.getId());
			prod.setName(stock.getName());
			prod.setDescription(stock.getDescription());
			prod.setPrice(stock.getPrice());
			prod.setCreatedAt(stock.getCreatedAt());
			
			return repository.save(prod);
		}
		
		return repository.save(stock);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
