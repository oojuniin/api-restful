package com.api.restful.product;

import java.io.Serializable;
import java.time.Instant;
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

	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Product save(Product stock) {
		stock.setCreatedAt(Instant.now());
		stock.setUpdatedAt(Instant.now());
		return repository.save(stock);
	}

	@Transactional
	public Product update(Long id, Product stock) {
		Product product = repository.findById(id).get();

		product.setId(id);
		product.setName(stock.getName());
		product.setDescription(stock.getDescription());
		product.setPrice(stock.getPrice());
		product.setCreatedAt(product.getCreatedAt());
		product.setUpdatedAt(Instant.now());

		return repository.save(product);

	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
