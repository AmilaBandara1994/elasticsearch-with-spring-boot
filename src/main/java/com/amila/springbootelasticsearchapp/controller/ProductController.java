package com.amila.springbootelasticsearchapp.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.amila.springbootelasticsearchapp.entity.Product;
import com.amila.springbootelasticsearchapp.service.ElasticSearchService;
import com.amila.springbootelasticsearchapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apis")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ElasticSearchService elasticSearchService;

    @GetMapping("/findall")
    public Iterable<Product> findAll(){
       return  productService.getProducts();
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProducts(product);
    }

    @GetMapping("/matchall")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchAllSearch();
        System.out.println(searchResponse.hits().hits().toString());
        return  searchResponse.hits().hits().toString();
    }

    @GetMapping("/matchallproducts")
    public List<Product> matchAllProducts() throws IOException {
        SearchResponse<Product> searchResponse = elasticSearchService.matchAllProductsSearch();
        System.out.println(searchResponse.hits().hits().toString());
        List<Hit<Product>> listOfHits = searchResponse.hits().hits();
        List<Product> listOfProducts = new ArrayList<>();
        for(Hit<Product> hit: listOfHits){
            listOfProducts.add(hit.source());
        }
        return  listOfProducts;
    }

}
