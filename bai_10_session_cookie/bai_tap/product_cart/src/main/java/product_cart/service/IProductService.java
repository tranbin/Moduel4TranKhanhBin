package product_cart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void saveProduct(Product product);
    void deleteProduct(int id);
    Product findProductById(int id);
}
