package project.chrtt.domain;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
    private Long pId;
    private String pName;
    private String pColor;
    private Long pPrice;
    private Long pQuantity;

    public Product(){
    }

    public Product(Long pId, String pName, String pColor, Long pPrice, Long pQuantity) {
        this.pId = pId;
        this.pName = pName;
        this.pColor = pColor;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
    }
}
