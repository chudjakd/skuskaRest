package jsf.login;

import db.repository.CustomerRepository;
import model.Boss;
import model.Customer;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class loginController implements Serializable {

    public String onSubmit(){
        FacesContext context= FacesContext.getCurrentInstance();
        Boss boss= context.getApplication().evaluateExpressionGet(context,"#{boss}",Boss.class);
        System.out.println(boss);
        CustomerRepository customerRepository= new CustomerRepository();
        List<Customer> allCustomers =customerRepository.getAllCustomer();
        boss.setAllCustomers(allCustomers);
        return "responselogin.xhtml";
    }
}
