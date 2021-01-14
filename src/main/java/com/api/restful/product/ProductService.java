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

	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Product save(Product stock) {
		return repository.save(stock);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
