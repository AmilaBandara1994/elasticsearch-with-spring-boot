package com.amila.springbootelasticsearchapp.service;

import com.amila.springbootelasticsearchapp.entity.Product;
import com.amila.springbootelasticsearchapp.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final  ProductRepo productRepo;

    public Iterable<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product insertProducts(Product product){
        return productRepo.save(product);
    }
    public Product updateProducts(Product product, int id){
        Product product1 = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        product1.setPrice(product.getPrice());
        productRepo.save(product);
        return product1;
    }
    public void deleteProducts(int id){
        productRepo.deleteById(id);
    }


}
