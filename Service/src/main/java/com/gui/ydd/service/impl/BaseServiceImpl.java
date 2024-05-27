package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T, V>
        extends ServiceImpl<M, T> implements BaseService<T, V> {

    @Override
    public List<T> getAll() {
        return super.list();
    }

    @Override
    public T getById(int id) {
        return super.getById(id);
    }

    @Override
    public void create(T entity) {
        boolean insertResult = super.save(entity);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert record");
        }
    }

    @Override
    public void update(T entity) {
        boolean updateResult = super.updateById(entity);
        if (!updateResult) {
            throw new RuntimeException("Failed to update record");
        }
    }

    @Override
    public void delete(int id) {
        boolean deleteResult = super.removeById(id);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete record");
        }
    }

    @Override
    public abstract V getDetails(int id) ;

    @Override
    public abstract List<V> getAllDetails() ;
}