/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import controller.CountryController;
import daos.GeneralDAO;
import java.math.BigInteger;
import models.Country;
import org.hibernate.SessionFactory;
import idaos.ICountryDAO;
import icontroller.ICountryController;
import java.math.BigDecimal;
import models.Region;
import view.CountryView;

/**
 *
 * @author erik
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
//        IJobDAO ijdao = new JobDAO(SessionFactory);
        // TODO code application logic here
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        System.out.println(SessionFactory);
        /**
         * untuk melakukan test insert >>
         *
         */
//        IJobDAO job = new JobDAO(SessionFactory);
//        Job job1 = new Job("AD_NANY","nani",200,299);
//        System.out.println(job.insert(job1));    

        
//        for (Job job : ijdao.search("AD_VP")) {
//            System.out.println(job.getId());
//            System.out.println(job.getTitle());
//            System.out.println(job.getMinSalary());
//            System.out.println(job.getMaxSalary());
//        }
//
//        for (Job job1 : job.getAll()) {
//            System.out.println(job1.getId());
//            System.out.println(job1.getTitle());
//            System.out.println(job1.getMinSalary());
//            System.out.println(job1.getMaxSalary());
//
//        }

//        GeneralDAO<Country> cdao = new GeneralDAO<>(SessionFactory,Country.class);
        ICountryController cc = new CountryController(SessionFactory);
        
        /**
         * untuk test getAll menggunakan ""
         * untuk test getById menggunakan ""
         * untuk test getSearch tinggal masukkan kata kunci di " "
         * 
         */
//        System.out.println(cc.getById("AU").getName()); 
        
//        Department department = new Department(new Short("270"), "Bawen");
//        System.out.println(cc.save("KY", "Kongok", "3"));
        System.out.println(cc.delete("AW"));
        
//        System.out.println(dc.save("281", "dept", "100", "1700"));

//            System.out.println(country.getId());
//            System.out.println(country.getName());
//            System.out.println(country.getRegion());
                      
        }
            
//           for (Country country : cdao.getData("AM")) {
//               System.out.println(country.getName());
//               System.out.println(country.getId());
//               System.out.println(country.getRegion());
//        }
           /**
            * untuk melakukan delete byId
            * untuk melakukan insert masukkan value yang akan di insert pada country dan juga ganti boolean menjadi false
            * untuk melakukan insert masukkan value yang akan di insert pada country dan juga ganti boolean menjadi false
            */
//          Country country = new Country("AY", "Ameritak", new Region(new BigDecimal(2) ));       
//        System.out.println(cdao.saveOrDelete(country, false));
        
//        CountryView countryView = new CountryView();
//        countryView.setVisible(true);
    }



























