package business;

import model.goodThingProject.GoodThing;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


public interface BusinessServiceInterface {

    public Integer delete(int id);
    public Integer create(GoodThing goodThing);
    public ArrayList<GoodThing> readALl();
    public Integer update(int id, GoodThing goodThing);
    public GoodThing getById(int id);
    public List<GoodThing> getByName(String name);
}
