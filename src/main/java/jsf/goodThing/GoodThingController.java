package jsf.goodThing;

import business.BusinessService;
import business.BusinessServiceInterface;
import db.repository.GoodThingRepository;
import db.service.implementation.GoodThingImplementation;
import jdk.jfr.Name;
import model.goodThingProject.GoodThing;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class GoodThingController implements Serializable {


//    @Inject
//    BusinessService businessService;

    @Inject
    BusinessService businessService;

    public GoodThingController() {

    }

    public String onCreateGoodThing(){
        FacesContext facesContext= FacesContext.getCurrentInstance();
        GoodThing goodThing= facesContext.getApplication().evaluateExpressionGet(facesContext, "#{goodThing}",GoodThing.class);
        businessService.create(goodThing);

        return "responseCreateNewGoodThing.xhtml";
    }


    public ArrayList<GoodThing> aaa(){
        ArrayList<GoodThing> allThings= new ArrayList<>();
        GoodThingRepository gtr= new GoodThingRepository();
        allThings= gtr.getAllGoodThings();
        ArrayList<GoodThing> allGoodThings= businessService.readALl();
        return allGoodThings;
    }

    public String editGoodThing(GoodThing goodThinger){

        GoodThing goodThing= goodThinger;
        Object key1=FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("goodThing",goodThing);

        return "edit.xhtml";
    }

    public String confirmEditGoodThing(){

        //FacesContext facesContext= FacesContext.getCurrentInstance();
        //GoodThing goodThing= facesContext.getApplication().evaluateExpressionGet(facesContext,"#{goodThing}",GoodThing.class);

        //System.out.println(goodThing.getRating()+ " "+goodThing.getName());

        return "editResponse.xhtml";
    }

    public String onSubmitDelete(GoodThing goodThinger){

        System.out.println("Do you wanna delete that thinger with id:"+goodThinger.getId());
        //goodThingRepository.deleteGoodThingById(goodThinger.getId());
        FacesContext facesContext= FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getRequestMap().put("goodThing",goodThinger);
        return "responseDeleteGoodThing.xhtml";
    }



}
