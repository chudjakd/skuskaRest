package db.repository;


import db.mapper.GoodThingMapper;
import model.goodThingProject.GoodThing;

import javax.enterprise.context.RequestScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
public class GoodThingRepository {

    private Connection connection =null;
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement ps=null;
    private String user="admin";
    private String password="admin";
    private String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private ArrayList<GoodThing> allGoodThings=new ArrayList<>();
    private GoodThingMapper goodThingMapper= new GoodThingMapper();
    public GoodThingRepository() {
    }

    public ArrayList<GoodThing> getAllGoodThings(){

        String sqlCommandForGetAllGoodThings="SELECT * FROM GOODTHING";


        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url,user,password);
            st= connection.createStatement();
            rs= st.executeQuery(sqlCommandForGetAllGoodThings);
            while(rs.next()){
                allGoodThings.add(goodThingMapper.mapGoodThing(rs));
            }

            return allGoodThings;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Integer createNewGoodThings(GoodThing goodThing){
        String sqlCommand="insert into goodthing (name,description,rating) values (?,?,?)";
        try {
            connection =DriverManager.getConnection(url,user,password);
            ps= connection.prepareStatement(sqlCommand);
            ps.setString(1,goodThing.getName());
            ps.setString(2,goodThing.getDescription());
            ps.setInt(3,goodThing.getRating());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Integer updateGoodThing(int id, GoodThing goodThing){
        String urlCommand="update goodthing set name=?,description=?,rating=?  where id=?";
        try {
            connection= DriverManager.getConnection(url,user,password);
            ps= connection.prepareStatement(urlCommand);
            ps.setString(1,goodThing.getName());
            ps.setString(2,goodThing.getDescription());
            ps.setInt(3,goodThing.getRating());
            ps.setInt(4,id);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public Integer deleteGoodThingById(int id ){

        String sqlCommand="delete from goodthing where id=?";

        try {
            connection= DriverManager.getConnection(url,user,password);
            ps= connection.prepareStatement(sqlCommand);
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public GoodThing getGoodThingById(int id){

        String sqlCommand="SELECT * FROM GOODTHING WHERE ID=? ";

        try {

            connection= DriverManager.getConnection(url,user,password);
            ps=connection.prepareStatement(sqlCommand);
            ps.setInt(1,id);
            rs= ps.executeQuery();

            if(rs.next()){
                return goodThingMapper.mapGoodThing(rs);
            }else{
                return null;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public ArrayList<GoodThing> getGoodThingByName(String name){
        String sqlCommand="SELECT * FROM GOODTHING WHERE LOWER(name) LIKE ? ";
        ArrayList<GoodThing> thingsByName= new ArrayList<>();
        try {

            connection= DriverManager.getConnection(url,user,password);
            ps=connection.prepareStatement(sqlCommand);
            ps.setString(1,"%"+name+"%");
            rs=ps.executeQuery();

            while(rs.next()){
                thingsByName.add(goodThingMapper.mapGoodThing(rs));
            }

            return thingsByName;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}
