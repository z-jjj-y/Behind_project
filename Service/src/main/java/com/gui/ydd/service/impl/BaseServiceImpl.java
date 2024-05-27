package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<M extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>, T>
        extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public List<T> getAll() {
        return list();
    }

    @Override
    public T getById(int id) {
        return getById(id);
    }

    @Override
    public void create(T entity) {
        boolean insertResult = save(entity);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert record");
        }
    }

    @Override
    public void update(T entity) {
        boolean updateResult = updateById(entity);
        if (!updateResult) {
            throw new RuntimeException("Failed to update record");
        }
    }

    @Override
    public void delete(int id) {
        boolean deleteResult = removeById(id);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete record");
        }
    }
}