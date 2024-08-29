package com.amila.springbootelasticsearchapp.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.amila.springbootelasticsearchapp.entity.Product;
import com.amila.springbootelasticsearchapp.util.ElasticSearchUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ElasticSearchService {

    private final ElasticsearchClient elasticsearchClient;

    public SearchResponse<Map> matchAllSearch() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Map>  searchResponse = elasticsearchClient.search(s->s.query(supplier.get()),Map.class);
        System.out.println("elasticsearch query is "+ supplier.get().toString());
        return searchResponse;
    }

    public SearchResponse<Product> matchAllProductsSearch() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Product>  searchResponse = elasticsearchClient.search(s->s.index("products"),Product.class);
        System.out.println("elasticsearch query is "+ supplier.get().toString());
        return searchResponse;
    }
}
