package com.session.cartmanagement.controller;

import com.session.cartmanagement.model.Product;
import com.session.cartmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes("cartList")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cartList")
    private List<Product> getCartList() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showCart(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "cart/show_list";
    }

    @GetMapping("/buy/{id}")
    public String showBuy(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "cart/buy";
    }

    @PostMapping("/buy/{id}")
    public String buyCart(@PathVariable int id,
                          @ModelAttribute("cartList") List<Product> products,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        Product product = productService.findById(id);
        product.setQuantity(1);
        products.add(product);
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm vào giỏ hàng thành công");
        return "redirect:/product";
    }

    @GetMapping("/cart")
    public String showCartList(@ModelAttribute("cartList") List<Product> cartList, Model model) {
        model.addAttribute("cartList", cartList);
        return "cart/cart";
    }

    @PostMapping("/pay")
    public String pay(Model model,
                      @ModelAttribute("cartList") List<Product> cartList,
                      RedirectAttributes redirectAttributes) {
        List<Product> products = productService.findAll();
        Iterator<Product> iterator = cartList.iterator();

        while (iterator.hasNext()) {
            Product cartProduct = iterator.next();
            for (Product product : products) {
                if (product.getId() == (cartProduct.getId())) {
                    product.setQuantity(product.getQuantity() - cartProduct.getQuantity());
                    productService.save(product);
                    iterator.remove();
                    break;
                }
            }
        }

        redirectAttributes.addFlashAttribute("message", "Thanh toán thành công");
        return "redirect:/product";
    }
}
