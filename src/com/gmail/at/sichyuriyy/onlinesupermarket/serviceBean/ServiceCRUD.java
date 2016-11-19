package com.gmail.at.sichyuriyy.onlinesupermarket.serviceBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ServiceCRUD<T> {
    
    public abstract void create(T obj);
    public abstract void delete(long id);
    public abstract void update(T obj);
    public abstract List<T> getAll();
    public abstract T getById(long id);

}
