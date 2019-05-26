/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;
import java.util.List;
import models.Job;

/**
 *
 * @author erik
 */
public interface IJobController {
    public List<Job> getAll();

    public Job getById(String id);

    public List<Job> search(Object keyword);

    public String insert(String id, String title, int Min_Value, int Max_value);

    public String update(String id, String title, int Min_Value, int Max_value);

    public String delete(String id);
}
