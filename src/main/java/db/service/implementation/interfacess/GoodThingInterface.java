package db.service.implementation.interfacess;

import model.goodThingProject.GoodThing;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

public interface GoodThingInterface {

    public ArrayList<GoodThing> getAllGoodThings();
    public Integer createNewGoodThing(GoodThing goodThing);
    public Integer deleteNewGoodThingById(int id);
    public Integer updateGoodThingById(int id, GoodThing goodThing);
    public GoodThing getGoodThingById(int id);
    public List<GoodThing> getGoodThingByName(String name);
}
