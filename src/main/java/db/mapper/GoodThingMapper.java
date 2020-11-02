package db.mapper;

import model.goodThingProject.GoodThing;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodThingMapper {

    public GoodThing mapGoodThing(ResultSet rs) throws SQLException {
        GoodThing goodThing= new GoodThing();
        goodThing.setId(rs.getInt("id"));
        goodThing.setName(rs.getString("name"));
        goodThing.setDescription(rs.getString("description"));
        goodThing.setRating(rs.getInt("rating"));
        return goodThing;
    }
}
