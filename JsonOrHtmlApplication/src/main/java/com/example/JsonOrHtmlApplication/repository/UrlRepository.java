package com.example.JsonOrHtmlApplication.repository;

import com.example.JsonOrHtmlApplication.domain.UrlEntity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepository implements RepositoryInterface{
    private final ArrayList<UrlEntity> entities = new ArrayList<>();

    @Override
    public void save(UrlEntity entity) {
        entities.add(entity);
    }

    @Override
    public List<UrlEntity> findAll() {
        return new ArrayList<>(entities);
    }
}
