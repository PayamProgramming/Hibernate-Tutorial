
package Model;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class hibernate {
    
    // PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    
    private String name ;
    
    private String family ;
    
    // A Fake Entity Without A Table
    @Embedded
    private Address address ;

    //Hibernate Doesnt Recognize This
    @Transient
    private String secret ;

    // Larg Texts
    @Lob
    private String set ;
    
    @OneToOne
    private ZipCode zipcode ;
    
    @OneToMany(mappedBy = "cell" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<CellPhone> cellphone = new ArrayList<>();

   
   

    
    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", family=" + family + ",  secret=" + secret;
    }

     public List<CellPhone> getCellphone() {
        return cellphone;
    }

    public void setCellphone(List<CellPhone> cellphone) {
        this.cellphone = cellphone;
    }

    
    
    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
    
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String namily) {
        this.family = namily;
    }
    
     public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
     public ZipCode getZipcode() {
        return zipcode;
    }

    public void setZipcode(ZipCode zipcode) {
        this.zipcode = zipcode;
    }


    
   

   
}
