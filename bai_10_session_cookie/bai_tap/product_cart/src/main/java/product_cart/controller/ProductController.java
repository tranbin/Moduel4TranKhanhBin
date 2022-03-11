package product_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_cart.model.Cart;
import product_cart.model.Product;
import product_cart.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @ModelAttribute("cart")
    public List<Product> setUpCart() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public ModelAndView returnIndex() {
        return new ModelAndView("list", "productList", productService.findAll());
    }

    @GetMapping("/add-product/{id}")
    public String addProduct(@PathVariable(name = "id") Integer id,
                             @ModelAttribute(name = "cart") List<Product> products,
                             RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        products.add(product);
        redirectAttributes.addFlashAttribute("message", "Add product Success");
        return "redirect:/";
    }

   /* @GetMapping("add")
    public ModelAndView getCreateForm() {
        return new ModelAndView("create", "products", new Product());
    }*/


}
