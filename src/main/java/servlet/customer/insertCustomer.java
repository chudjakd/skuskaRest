package servlet.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myApps/insertCustomer")
public class insertCustomer extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter pw= resp.getWriter();
//
//        pw.println("Hello world");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String name= req.getParameter("name");
        String surname=req.getParameter("surname");
        PrintWriter pw=resp.getWriter();
        pw.println("Id: "+id+" Name: "+name+" Surname: "+surname);
        pw.close();

    }


}
