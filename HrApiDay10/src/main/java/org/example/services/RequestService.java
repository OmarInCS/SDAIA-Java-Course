package org.example.services;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestService {

    private int count;

    public int getCount() {
        return ++count;
    }
}
