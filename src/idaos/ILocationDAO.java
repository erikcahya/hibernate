/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author erik
 */
public interface ILocationDAO {
    public List<Location> getAll();
    public List<Location> getById(String id);
    public List<Location> search(Object keyword);
    public boolean insert(Location location);
    public boolean update(Location location);
    public boolean delete(String id);
}
