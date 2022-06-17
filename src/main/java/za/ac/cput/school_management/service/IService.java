package za.ac.cput.school_management.service;

import java.util.List;

public interface IService <T, X>{
    T create(T t);
    List<T> readAll();
    void delete(X x);
}
