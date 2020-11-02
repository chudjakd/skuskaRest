package jndi;

import model.Boss;
import model.Customer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class CustomerJndi {

    public static void main(String[] args) throws NamingException {

        Hashtable<String,String> environment= new Hashtable<String,String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.fscontext.RefFSContextFactory");
        environment.put(Context.PROVIDER_URL,"file:D:/Users");
        Context context=new InitialContext(environment);

        context.bind("Jea",new Boss("Boss","Boosovic"));

    }
}
