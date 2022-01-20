package com.example.lab2shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @GetMapping("/shopping-cart")
    public ModelAndView viewShoppingCart(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Map<String, ShoppingCart> cartItems = (Map<String, ShoppingCart>) session.getAttribute("cartLine");
        double total = 0;
        if (cartItems == null)
            cartItems = new HashMap<>();
        for (ShoppingCart cart : cartItems.values()) {
            total += cart.getQuantity() * cart.getProduct().getPrice();
        }
        params.put("cartItems", cartItems.values());
        params.put("total", total);
        return new ModelAndView("shoppingcart", params);

    }

    @PostMapping("add-item-to-cart")
    public ModelAndView addItemToCart(@RequestParam("productNumber") String productNumber, HttpSession session) {
        Map<String, Object> cartLine = (Map<String, Object>) session.getAttribute("cartLine");
        Map<String, Object> params = new HashMap<>();

        if (cartLine == null) {
            cartLine = new HashMap<>();
        }
        Map<String, Object> productList = (Map<String, Object>) session.getAttribute("productList");
        Product item = (Product) productList.get(productNumber);
        session.setAttribute("productList", productList);

        if (cartLine.containsKey(productNumber)) {
            ShoppingCart productLine = (ShoppingCart) cartLine.get(productNumber);
            productLine.setQuantity(productLine.getQuantity() + 1);
            cartLine.put(productNumber, productLine);
        } else {
            ShoppingCart productLine = new ShoppingCart();
            productLine.setQuantity(1);
            productLine.setProduct(item);
            cartLine.put(item.getProductNo(), productLine);
        }

        session.setAttribute("cartLine", cartLine);
        return new ModelAndView("redirect:shoppingcart", params);
    }

    @PostMapping("remove-item-from-cart")
    public ModelAndView removeItemFromCart(@RequestParam("productNumber") String productNumber, HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Map<String, ShoppingCart> cartItems = (Map<String, ShoppingCart>) session.getAttribute("cartLine");
        ShoppingCart productInCart = cartItems.get(productNumber);
        if (productInCart.getQuantity() == 1)
            cartItems.remove(productNumber);
        else {
            productInCart.setQuantity(productInCart.getQuantity() - 1);
            cartItems.put(productNumber, productInCart);
        }
        session.setAttribute("cartLine", cartItems);
        params.put("cartItems", cartItems);
        return new ModelAndView("redirect:shoppingcart", params);
    }
}
