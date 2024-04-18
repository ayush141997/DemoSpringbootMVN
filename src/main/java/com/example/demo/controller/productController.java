package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import com.example.demo.dao.product;
import com.example.demo.model.productModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class productController{
    @Autowired
    private productModel productrepo;
    product prod;

    @RequestMapping(value="/product", method=RequestMethod.POST)
    public @ResponseBody String createProduct(@RequestBody product prods,HttpServletResponse res) {
            productrepo.save(prods);
            return "Created";
    }
    
    @RequestMapping(value="/product/{ch}", method=RequestMethod.GET)
    public List<product> getProdByName(@PathVariable("ch") String ch) {
        return productrepo.findByPnameContaining(ch);
    }
    
    
}

