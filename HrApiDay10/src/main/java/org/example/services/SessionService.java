package org.example.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class SessionService implements Serializable {

    private int count;

    public int getCount() {
        return ++count;
    }
}
