package jsf.loginRegister;

import model.loginRegisterForm.Login;
import model.loginRegisterForm.Register;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginRegisterController implements Serializable {

    public String onLogin(){
        FacesContext facesContext= FacesContext.getCurrentInstance();
        Login login= facesContext.getApplication().evaluateExpressionGet(facesContext,"#{login}",Login.class);
        ExternalContext ec= FacesContext.getCurrentInstance().getExternalContext();
        System.out.println(ec.getRequestContextPath());
        return "loginRegisterResponse.xhtml";
    }

    public String loginAgain(){

        return "loginRegisterForm.xhtml";
    }

    public String onRegistration(){
        FacesContext facesContext= FacesContext.getCurrentInstance();
        Register register= facesContext.getApplication().evaluateExpressionGet(facesContext,"#{register}",Register.class);
        return "registerResponse.xhtml";
    }
}
