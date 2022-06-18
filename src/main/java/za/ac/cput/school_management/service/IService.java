package za.ac.cput.school_management.service;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import java.util.List;

public interface IService<T, ID> {
    //Create a new record
    T create(T t);

    //Read all records
    List<T> findAll();

    //Read a record by its ID
    T findById(ID id);

    //Delete a record by its ID
    void delete(ID id);
}
