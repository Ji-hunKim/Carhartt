package project.chrtt.domain;

public class Order_p {
    private Long o_id;
    private Long o_price;
    private Long o_t_price;
    private Long o_cnt;
    private String o_code;
    private String o_state;
    private Long o_state_num;
    private Long m_id;
    private Long p_id;

    public Order_p() {
    }

    public Order_p(Long o_id, Long o_price, Long o_t_price, Long o_cnt, String o_code, String o_state, Long o_state_num, Long m_id, Long p_id) {
        this.o_id = o_id;
        this.o_price = o_price;
        this.o_t_price = o_t_price;
        this.o_cnt = o_cnt;
        this.o_code = o_code;
        this.o_state = o_state;
        this.o_state_num = o_state_num;
        this.m_id = m_id;
        this.p_id = p_id;
    }
}
