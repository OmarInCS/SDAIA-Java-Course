package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@ApplicationScoped
public class ApplicationService {

    private int count;

    public int getCount() {
        return ++count;
    }
}
