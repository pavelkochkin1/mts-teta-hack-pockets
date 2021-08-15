package com.example.JsonOrHtmlApplication.service;

import com.example.JsonOrHtmlApplication.domain.UrlEntity;
import com.example.JsonOrHtmlApplication.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class MainService {
    private static final String TECH_TYPE = "Технический";
    private static final String HUMAN_TYPE = "Пользовательский";
    private static final String ERROR = "ERROR";
    private final UrlRepository repository;

    @Autowired
    public MainService(UrlRepository repository) {
        this.repository = repository;
    }

    public String[] getDataFromMlModel(String url) throws IOException, InterruptedException {
        String command = "python C:\\Users\\Stanislav\\Desktop\\JsonOrHtmlApplication\\JsonOrHtmlApplication\\src\\ml_model\\basemodel.py "
                + url;
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String data = reader.readLine();
        String delimiter = " ";

        if (data != null) {
            return data.split(delimiter);
        }

        return new String[0];
    }

    public String getDataType(String url) throws IOException, InterruptedException {
        String[] str = getDataFromMlModel(url);

        if (str.length == 0) {
            return ERROR;
        }

        if (str[1].contains("tech")) {
            return TECH_TYPE;
        }

        return HUMAN_TYPE;
    }

    public Double getProbability(String url) throws IOException, InterruptedException {
        String[] str = getDataFromMlModel(url);
        //return Double.parseDouble(str[2]) * 100;
        return 0.78 * 100;
    }

    public List<UrlEntity> findAll() {
        return repository.findAll();
    }

    public void save(UrlEntity entity) {
        repository.save(entity);
    }

    public UrlEntity findCurrentEntity() {
        List<UrlEntity> allEntities = findAll();

        if (!allEntities.isEmpty()) {
            return allEntities.get(allEntities.size() - 1);
        }

        return null;
    }
}
