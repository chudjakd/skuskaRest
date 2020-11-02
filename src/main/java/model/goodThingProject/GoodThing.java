package model.goodThingProject;



import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.TransactionScoped;
import java.io.Serializable;





@SessionScoped
@Named
public class GoodThing implements Serializable {


    private int id;
    private String name;
    private String description;
    private Integer rating;


    public GoodThing() {

    }

    public GoodThing(int id, String name, String description, Integer rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "GoodThing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
