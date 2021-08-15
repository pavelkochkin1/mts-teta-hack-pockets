package com.example.JsonOrHtmlApplication.domain;

import javax.validation.constraints.NotBlank;

public class UrlEntity {

    @NotBlank(message = "URL адрес должен быть заполнен")
    private String link;
    private String dataType;
    private Double probability;

    public UrlEntity(String link, String dataType) {
        this.link = link;
        this.dataType = dataType;
    }

    public UrlEntity(String link, String dataType, Double probability) {
        this.link = link;
        this.dataType = dataType;
        this.probability = probability;
    }

    public UrlEntity(String link) {
        this.link = link;
    }

    public UrlEntity() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
