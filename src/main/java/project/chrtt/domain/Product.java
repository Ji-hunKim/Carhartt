package project.chrtt.domain;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
    private Long p_id;
    private String p_name;
    private String p_color;
    private Long p_price;

    public Product(){
    }

    public Product(Long p_id, String p_name, String p_color, Long p_price) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_color = p_color;
        this.p_price = p_price;
    }
}
