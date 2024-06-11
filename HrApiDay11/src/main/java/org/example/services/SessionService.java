package org.example.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.example.dao.DepartmentDAO;

import java.io.Serializable;

@SessionScoped
public class SessionService implements Serializable {

    private int count;

    @Inject
    DepartmentDAO dao;

    public int getCount() {
        return ++count;
    }


    @PostConstruct
    public void init() {
        System.out.println("Session object created");
    }

    @PreDestroy
    public void kill() {
        System.out.println("Session object will be killed");
    }

}
