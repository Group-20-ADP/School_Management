package za.ac.cput.school_management.service;

public interface IService <T, X>{
    T create(T t);
    T read(X x);
    void delete(X x);
}
