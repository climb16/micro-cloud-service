package online.jfree.micro.cloud.service.order.entity;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/18 13:02
 * @since 1.0
 */
public class OrderDTO implements java.io.Serializable {

    private String id;

    private String name;

    private Double money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }
}
