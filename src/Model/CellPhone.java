
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NamedQuery;


@Entity
@NamedQuery(name = "CellPhones" , query = "from CellPhone where id>2 and id<6")
public class CellPhone {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String firstnumber ;
    private String secondnumber ;
    private String thirdnumber ;

    @Override
    public String toString() {
        return "CellPhone{" + "id=" + id + ", firstnumber=" + firstnumber + ", secondnumber=" + secondnumber + ", thirdnumber=" + thirdnumber + ", cell=" + cell + '}';
    }
    
    @ManyToOne
    private hibernate cell ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstnumber() {
        return firstnumber;
    }

    public void setFirstnumber(String firstnumber) {
        this.firstnumber = firstnumber;
    }

    public String getSecondnumber() {
        return secondnumber;
    }

    public void setSecondnumber(String secondnumber) {
        this.secondnumber = secondnumber;
    }

    public String getThirdnumber() {
        return thirdnumber;
    }

    public void setThirdnumber(String thirdnumber) {
        this.thirdnumber = thirdnumber;
    }
    
     public hibernate getCell() {
        return cell;
    }

    public void setCell(hibernate cell) {
        this.cell = cell;
    }
}
