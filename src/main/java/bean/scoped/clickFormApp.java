package bean.scoped;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class clickFormApp {

    private int clickValue=0;


    public String incrementValue(){
        setClickValue(getClickValue()+1);
        return "clickForm.xhtml";
    }

    public int getClickValue() {
        return clickValue;
    }

    public void setClickValue(int clickValue) {
        this.clickValue = clickValue;
    }
}
