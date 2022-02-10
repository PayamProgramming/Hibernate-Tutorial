package Test;

import Model.Address;
import Model.CellPhone;
import Model.ZipCode;
import Model.hibernate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {

    public static void main(String[] args) {
        hibernate m = new hibernate(); // Transient Stage
        m.setName("Ali");
        m.setFamily("Anmoo");
        m.setSecret("q");
        m.setSet("""
                 Date: October 13, 2021
                 Author: Tech Collective
                 1 Comment
                 Most software is built on open-source today, with 99% of enterprise codebases containing open-source code. In fact, the technology you are using to read this would have at least one open-source component. As more businesses begin digitising their products and services to innovate and create new value, developers and their skills will become increasingly important.
                 
                 Software developers excel in not just pushing codes but in fostering innovation, security, and agility in a business. They play a bigger role in digitisation initiatives, with \u2018coding and software development\u2019 cited as one of the most important skills (22%) by employers in Singapore to assist with business digitisation plans.
                 
                 However, business leaders must keep in mind that even employing the best developers in the world will not automatically improve the quality of their products and services. Instead, businesses need to invest resources in creating an environment that allows their developers to thrive.""");

        Address add = new Address();
        add.setCity("Tehran");
        add.setStreet("iad");
        m.setAddress(add); // Add Address Methods To Hibernate Entity

        ZipCode zc = new ZipCode();
        zc.setZipcode("22");
        m.setZipcode(zc); // Add Zipcode Entity To Hibernate

        CellPhone cf = new CellPhone();
        cf.setFirstnumber("09125634276");
        cf.setSecondnumber("09123224345");
        m.getCellphone().add(cf);
        cf.setCell(m);

        SessionFactory sf = (new Configuration()).configure("/Config/Config.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();// Persistent Stage

        // HQL Querys
        Query q = session.createQuery("from hibernate");
        q.setFirstResult(0);
        q.setMaxResults(5);
        List<hibernate> hb = q.list();
        for (hibernate h : hb) {
            if (h.getId().equals(1)) {
                System.out.println("\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++ \nHQL Select *");
                System.out.println(h.toString());
            } else {
                System.out.println(h.toString());
            }
        }
        System.out.println("HQL Select *"
                + "\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");

        // Parameter Binding 
        String hql = "from hibernate where id=:idvalue";
        Query q2 = session.createQuery(hql);
        q2.setParameter("idvalue", 2);
        List<hibernate> idvalue = q2.list();
        System.out.println("*\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++ \nParameter Binding +");
        for (hibernate idvalue2 : idvalue) {
            System.out.println(idvalue2);
        }
        System.out.println("Parameter Binding *\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");

        // @NamedQuery 
        Query q3 = session.getNamedQuery("CellPhones");
        List<CellPhone> cellphones = q3.list();
        System.out.println("*\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++\nNamed Query +");
        for (CellPhone cellphones2 : cellphones) {
            System.out.println(cellphones2);
        }
        System.out.println("Named Query *\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");

        // Criteria
        Criteria cr = session.createCriteria(hibernate.class);
        cr.add(Restrictions.ilike("name", "%Mos%"));
        List<hibernate> h = cr.list();

        for (hibernate h2 : h) {
            if (h2.getId().equals(1)) {
                System.out.println("*\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++\nCriteria Query +");
                System.out.println(h2.toString());
            } else {
                System.out.println(h2.toString());
            }
        }
        System.out.println("Criteria Query *\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");

        /* Native Query
        String Sql = "select from cellphone where id=10";
        SQLQuery q4 = session.createSQLQuery(Sql);
        List <CellPhone> cellphones2 = q4.list();
        System.out.println("*\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++\nNative Query ");
        for (CellPhone cellphones3 : cellphones2){
            System.out.println(cellphones3);
        }
         System.out.println("Native Query *\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");
         */
        session.save(m);
        session.save(zc);
        // Select Using Get Method
        CellPhone cph = new CellPhone();
        cph = session.get(CellPhone.class, 1);
        //session.save(cf); because of CascadeType Doesnt Need To
        tx.commit(); // Detached Stage
        session.close();
        System.out.println("\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++\nCellPhone Get Select +");
        System.out.println(cph.toString());
        System.out.println("CellPhone Get Select +\n +++++++++++++++++++++++++++++++++ \n +++++++++++++++++++++");

    }

}
