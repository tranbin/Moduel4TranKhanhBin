package product_cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_cart.model.Product;
import product_cart.repository.IProductRepository;
import product_cart.service.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
