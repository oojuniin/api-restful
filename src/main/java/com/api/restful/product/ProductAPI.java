package com.api.restful.product;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductAPI implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> stock = service.findById(id);
		if (stock.isEmpty()) {
			log.error("ID " + id + " is not existed.");
			ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(stock.get());
	}

	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		product = service.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		return ResponseEntity.created(uri).body(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {

		if (service.findById(id).isEmpty()) {
			log.error("ID " + id + " is not existed.");
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(service.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		if (service.findById(id).isEmpty()) {
			log.error("ID " + id + " is not existed.");
			ResponseEntity.notFound().build();
		}

		service.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
