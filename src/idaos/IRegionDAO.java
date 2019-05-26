/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
/**
 *
 * @author erik
 */
public interface IRegionDAO {
    public List<Region> getAll();
    public Region getById(BigDecimal id);
    public Region search(String key);
    public boolean insert(Region region);
    public boolean update(Region region);
    public boolean delete(int id);
}
