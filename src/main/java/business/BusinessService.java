package business;

import db.service.implementation.GoodThingImplementation;
import db.service.implementation.interfacess.GoodThingInterface;
import model.goodThingProject.GoodThing;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
public class BusinessService implements BusinessServiceInterface {

    @Inject
    GoodThingImplementation goodThingImplementation;

    @Override
    public Integer delete(int id) {
        return goodThingImplementation.deleteNewGoodThingById(id);
    }

    @Override
    public Integer create(GoodThing goodThing) {
        return goodThingImplementation.createNewGoodThing(goodThing);
    }

    @Override
    public ArrayList<GoodThing> readALl() {
        return goodThingImplementation.getAllGoodThings();
    }

    @Override
    public Integer update(int id, GoodThing goodThing) {
        return goodThingImplementation.updateGoodThingById(id,goodThing);
    }

    @Override
    public GoodThing getById(int id) {
        return goodThingImplementation.getGoodThingById(id);
    }

    @Override
    public ArrayList<GoodThing> getByName(String name) {
        return goodThingImplementation.getGoodThingByName(name);
    }
}
