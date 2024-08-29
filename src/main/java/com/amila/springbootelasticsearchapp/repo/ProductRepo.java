package com.amila.springbootelasticsearchapp.repo;

import com.amila.springbootelasticsearchapp.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {
}
