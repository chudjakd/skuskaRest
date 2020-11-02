package rest;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Path("/MyRestService")
@ApplicationPath("/api")
public class HelloWorld extends Application {

    @GET
    @Path("/hello")
    public String sayHello(){
        return "Hello pice uz by to mohlo ist";
    }

    @GET
    @Path("/kokot")
    public String sayKokot(){
        return "kokot a pica a kokotina";
    }

    @GET
    @Path("/biac")
    public Response getObject(){
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Its okay")
                .build();
    }
}
