package com.example.JsonOrHtmlApplication.repository;

import com.example.JsonOrHtmlApplication.domain.UrlEntity;

import java.util.List;

public interface RepositoryInterface {
    void save(UrlEntity entity);

    List<UrlEntity> findAll();
}
