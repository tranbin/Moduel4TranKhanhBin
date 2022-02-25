package product.service;

import product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {

    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Nokia", 20.0, "CN", "Chinese"));
        products.put(2, new Product(2, "Samsung", 20.0, "KR", "Korea"));
        products.put(3, new Product(3, "Oppo", 20.0, "CN", "Chinese"));
        products.put(4, new Product(4, "Xiaomi", 20.0, "CN", "Chinese"));
        products.put(5, new Product(5, "Mobel", 20.0, "CN", "Chinese"));
        products.put(6, new Product(6, "Iphone", 20.0, "USA", "America"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (int i = 1 ; i <= products.size();i++){
            if (products.get(i).getName().equalsIgnoreCase(name)){
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
