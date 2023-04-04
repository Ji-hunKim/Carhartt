package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.Product;
import project.chrtt.repository.mybatis.ProductBuyMapper;

import java.util.List;

@Service
public class ProductBuyService {

    private final ProductBuyMapper productBuyMapper;

    public ProductBuyService(ProductBuyMapper productBuyMapper) {
        this.productBuyMapper = productBuyMapper;
    }

    public List<Product> findAllProducts(){
        List<Product> productList = productBuyMapper.findAllProducts();
        if(productList == null) return null;
        else return productList;
    }

    public Product findById(String pId){
        Product product = productBuyMapper.findById(pId);
        if(product == null) return null;
        else return product;
    }
}
