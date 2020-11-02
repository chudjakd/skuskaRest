package rest.thing;
import business.BusinessService;

import model.goodThingProject.GoodThing;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/rest")
@Path("/things")
public class RestThingService extends Application {

    @Inject
    BusinessService businessService;

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Path("/allThings")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GoodThing> getAllGoodThings() {
        // Return some cliched textual content
        return businessService.readALl();
    }

    @GET
    @Path("/thing/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public GoodThing getGoodThingById(@PathParam("id") int id){

        return businessService.getById(id);

    }

    @GET
    @Path("thing/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GoodThing> getGoodThingsByName(@PathParam("name") String name){
        return businessService.getByName(name);
    }




//    public static void main(String[] args) throws IOException {
//        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
//        server.start();
//
//        System.out.println("Server running");
//        System.out.println("Visit: http://localhost:9998/helloworld");
//        System.out.println("Hit return to stop...");
//        System.in.read();
//        System.out.println("Stopping server");
//        server.stop(0);
//        System.out.println("Server stopped");
//    }
}
