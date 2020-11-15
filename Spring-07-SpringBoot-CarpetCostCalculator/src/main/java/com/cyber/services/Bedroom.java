package com.cyber.services;

import com.cyber.interfaces.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bedroom implements Room {

    @Value("${bedroom}")
    private double length;

    @Override
    public double area() {
        return Math.pow(length, 2);
    }

    @Override
    public void print() {
        System.out.println("Area of bedroom is : " + area());
    }
}
