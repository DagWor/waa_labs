package com.example.lab2shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    @GetMapping("/addProduct")
    public ModelAndView addProductPage(){
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView products(HttpSession session){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> productList = (Map<String, Object>)session.getAttribute("productList");

        if(productList == null){
            productList = new HashMap<>();
        }
        params.put("productList", productList.values());

        return new ModelAndView("products", params);
    }

    @PostMapping("/addProduct")
    public ModelAndView addProduct(HttpSession session){
        Map<String, Object> params = new HashMap<>();
        params.put("product", new Product());
        return new ModelAndView("product", params);
    }

    @PostMapping("/add")
    public ModelAndView add(HttpSession session, @Valid Product product, BindingResult bindingResult){

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("product");
            return modelAndView;
        }
        Map<String, Object> params = new HashMap<>();

        if(product != null) {
            Map<String, Object> productList = (Map<String, Object>)session.getAttribute("productList");

            if(productList == null){
                productList = new HashMap<>();
                session.setAttribute("productList", productList);
            }
            productList.put(product.getProductNo(), product);
            params.put("productList", productList.values());
        }
        return new ModelAndView("redirect:products", params);
    }

    @PostMapping("/removeProduct")
    public ModelAndView removeProduct(@RequestParam("productNumber") String productNumber,
                                      HttpSession session){

        Map<String, Object> params = new HashMap<>();
        if(productNumber != null) {
            Map<String, Object> productList = (Map<String, Object>)session.getAttribute("productList");

            if(productList == null){
                productList = new HashMap<String, Object>();
                session.setAttribute("productList", productList);
            }
            productList.remove(productNumber);
            params.put("productList", productList.values());
        }

        return new ModelAndView("redirect:products", params);
    }
}
