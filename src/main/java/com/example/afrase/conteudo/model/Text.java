package com.example.afrase.conteudo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Text {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private String site;
    private Date update_at;
    private Date create_at;

    public Text() {
        this.create_at = new Date();
        this.update_at = new Date();
    }

    public Text(String description, String site) {
        this.description = description;
        this.site = site;
        this.update_at = new Date();
        this.create_at = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}