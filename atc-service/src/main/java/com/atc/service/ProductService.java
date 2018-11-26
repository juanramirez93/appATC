package com.atc.service;
import com.atc.connection.ProductEM;
import com.atc.model.Product;

import java.util.List;

public class ProductService {
    ProductEM productEM;

    public ProductService() {
        this.productEM = new ProductEM();
    }

    public List<Product> getAll() {
        return productEM.getAll();
    }

    public Product[] getAllProducts() {
        List<Product> prod = getAll();
        Product[] prodArray = new Product[prod.size()];
        prodArray = prod.toArray(prodArray);
        return prodArray;
    }

    public List<Product> search(String str) {
        return productEM.search(str);
    }

    public void update(Product product) {
        productEM.update(product);
    }
}
