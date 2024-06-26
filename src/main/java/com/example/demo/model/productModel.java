package com.example.demo.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.demo.dao.*;

public interface productModel extends CrudRepository<product, Long> {
    
    @Query(value = "Select * from product where product.pname like %?1%", nativeQuery = true)
    public List<product> findByPnameContaining(String pname);
}