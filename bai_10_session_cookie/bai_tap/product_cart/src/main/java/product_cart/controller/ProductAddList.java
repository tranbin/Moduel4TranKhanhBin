package product_cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import product_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductAddList {

    @ModelAttribute("cart")
    public List<Product> setUpCart() {
        return new ArrayList<>();
    }
    @GetMapping("/cartShop")
    public String getProductList(@SessionAttribute(name = "cart") List<Product> products, Model model) {
        model.addAttribute("productList", products);
        return "list_product";
    }
}
