package com.ecommerce.ElasticSearch.repos;

import com.ecommerce.ElasticSearch.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Long> {
    Iterable<Product> findAllByName(String query);
}
