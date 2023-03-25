package project.chrtt.domain;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
    private String pName;
    private String pColor;
    private Long pPrice;

    public Product(){
    }

    public Product(String pName, String pColor, Long pPrice) {
        this.pName = pName;
        this.pColor = pColor;
        this.pPrice = pPrice;
    }
}
