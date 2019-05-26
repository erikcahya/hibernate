/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import daos.GeneralDAO;
import icontroller.ICountryController;
import java.util.List;
import models.Country;
import idaos.ICountryDAO;
import java.math.BigDecimal;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class CountryController implements ICountryController{
    
    private GeneralDAO<Country> cdao;
    
public CountryController(SessionFactory factory) {
    cdao = new GeneralDAO(factory,Country.class);
}    
    
    @Override
    public List<Country> getAll() {
        return cdao.getData("");
    }

    @Override
    public Country getById(String id) {
        return cdao.getById(id);
    }

    @Override
    public List<Country> search(Object keyword) {
        return cdao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String region) {
        String result = "";
        Country country = new Country(id, name, new Region(new BigDecimal(region)));
        if(cdao.saveOrDelete(country, false)) {
            result = "data berhasil disimpan";
        } else {
            result="failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Country country = new Country(id);
        if (cdao.saveOrDelete(country, true)) {
        result = "Sukses";
    } else {
         result = "fail";
        }
        return result;
    }
}
