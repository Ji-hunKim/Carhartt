package project.chrtt.domain;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
    private Long pId;
    private String pName;
    private String pColor;
    private Long pPrice;

    public Product(){
    }

    public Product(Long pId, String pName, String pColor, Long pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pColor = pColor;
        this.pPrice = pPrice;
    }
}
