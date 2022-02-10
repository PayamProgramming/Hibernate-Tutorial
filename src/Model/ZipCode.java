
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ZipCode {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String zipcode; 

    @Override
    public String toString() {
        return "ZipCode{" + "zipcode=" + zipcode + '}';
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
}
