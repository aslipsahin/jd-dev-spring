package com.cyber.services;

import com.cyber.interfaces.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Kitchen implements Room {

    @Value("${kitchen}")
    private double radius;

    @Override
    public double area() {
        return 3.14*Math.pow(radius, 2);
    }

    @Override
    public void print() {
        System.out.println("Area of kitchen is : " + area());
    }

}
