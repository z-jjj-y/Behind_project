package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BaseService<T,V> extends IService<T> {
    List<T> getAll();

    T getById(int id);

    void create(T entity);

    void update(T entity);

    void delete(int id);

    V getDetails(int id);

    List<V> getAllDetails();
}