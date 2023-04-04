package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.Product;
import project.chrtt.repository.mybatis.ProductManageMapper;

import java.util.List;

@Service
public class ProductManageService {
    private final ProductManageMapper productManageMapper;

    public ProductManageService(ProductManageMapper productManageMapper) {
        this.productManageMapper = productManageMapper;
    }

    public List<Product> findAllProducts(){
        List<Product> productList = productManageMapper.findAllProducts();
        if(productList == null) return null;
        else return productList;
    }

    public Product findById(String pId){
        Product product = productManageMapper.findById(pId);
        if(product == null) return null;
        else return product;
    }

    public void addProduct(Product product){
        productManageMapper.addProduct(product);
    }
    public void updateProduct(Product product) {
        productManageMapper.updateProduct(product);}
}
