package com.ecommerce.ElasticSearch.repos;

import com.ecommerce.ElasticSearch.models.Category;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepo extends ElasticsearchRepository<Category, UUID>{
    Iterable<Category> findAllByName(String query);
    // Custom search query to match in both 'name' and 'description'
    @Query("{ \"multi_match\": { \"query\": \"?0\", \"fields\": [ \"name\", \"description\" ] } }")
    List<Category> searchByNameOrDescription(String searchText);
}
