package db.service.implementation;

import db.repository.GoodThingRepository;
import db.service.implementation.interfacess.GoodThingInterface;
import model.goodThingProject.GoodThing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class GoodThingImplementation implements GoodThingInterface {

    @Inject
    GoodThingRepository goodThingRepository;

    @Override
    public ArrayList<GoodThing> getAllGoodThings() {
        ArrayList<GoodThing> allGoodThingsFromDatabase=goodThingRepository.getAllGoodThings();
    if(allGoodThingsFromDatabase!=null){
        return allGoodThingsFromDatabase;
    }
    else {
        return null;
    }
    }

    @Override
    public Integer createNewGoodThing(GoodThing goodThing) {
        return goodThingRepository.createNewGoodThings(goodThing);
    }

    @Override
    public Integer deleteNewGoodThingById(int id) {
        return goodThingRepository.deleteGoodThingById(id);
    }

    @Override
    public Integer updateGoodThingById(int id, GoodThing goodThing) {
        return goodThingRepository.updateGoodThing(id,goodThing);
    }

    @Override
    public GoodThing getGoodThingById(int id) {
        return goodThingRepository.getGoodThingById(id);
    }

    @Override
    public ArrayList<GoodThing> getGoodThingByName(String name) {
        return goodThingRepository.getGoodThingByName(name);
    }
}
