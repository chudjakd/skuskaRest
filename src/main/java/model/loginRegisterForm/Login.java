package model.loginRegisterForm;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class Login implements Serializable {

    private String name;
    private String password;
    private boolean rememberMe;
    private List<Product> Products;

    public Login() {
        List<Product> products= new ArrayList<>();
        products.add(new Product(0001,"Product 1",1.5,1));
        products.add(new Product(0002,"Product 2",2.3,2));
        products.add(new Product(0003,"Product 3",15.5,3));
        products.add(new Product(0004,"Product 4",12.5,4));
        setProducts(products);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
