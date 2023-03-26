package project.chrtt.service;

import org.springframework.stereotype.Service;
import project.chrtt.domain.Product;
import project.chrtt.repository.mybatis.ProductMapper;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> findAllProducts(){
        List<Product> productList = productMapper.findAllProducts();
        if(productList == null) return null;
        else return productList;
    }

    public Product findById(String pId){
        Product product = productMapper.findById(pId);
        if(product == null) return null;
        else return product;
    }

    public void addProduct(Product product){
        productMapper.addProduct(product);
    }
    public void updateProduct(Product product) {productMapper.updateProduct(product);}
}
