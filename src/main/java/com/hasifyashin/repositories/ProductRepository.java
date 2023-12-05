package com.hasifyashin.repositories;

import com.hasifyashin.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product) {
        String cmd = "INSERT INTO inventory values (NULL,?, ?)";
        jdbcTemplate.update(cmd, product.getName(), product.getPrice());
    }
    public List<Product> getProducts() {
        String query = "SELECT * from inventory";
        RowMapper<Product> rowMapper = (resultSet, i) -> {
            String name = resultSet.getString("name");
            BigDecimal price = resultSet.getBigDecimal("price");
            return new Product(name, price);
        };
        return jdbcTemplate.query(query, rowMapper);
    }
}
