package com.cyber.services;

import com.cyber.interfaces.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LivingRoom implements Room {

    @Value("${livingRoom}")
    private double[] sides;

    @Override
    public double area() {
        return sides[0]*sides[1];
    }

    @Override
    public void print() {
        System.out.println("Area of living room is : " + area());
    }
}
