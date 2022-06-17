package za.ac.cput.school_management.service;
/**
 * Author       : Kurtney Clyde Jantjies 218138105
 * Due Created : 18/06/2022
 * Description  : School Management System(Milestone Project)
 */

import java.util.List;

public interface IService <T, X>{
    T create(T t);
    List<T> readAll();
    void delete(X x);
}
