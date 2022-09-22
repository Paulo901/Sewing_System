package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Products;
import com.api.Sewing_System.Repositories.ProductRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public Products save(Products itemsModel) {return productRepository.save(itemsModel);}
    public List<Products> findAll() {
        return productRepository.findAll();
    }
    @Transactional
    public void delete(Products itemsModel) {
        productRepository.delete(itemsModel);
    }
    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }
}
