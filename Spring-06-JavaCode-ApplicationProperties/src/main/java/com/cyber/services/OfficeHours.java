package com.cyber.services;

import com.cyber.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 7;
    }
}
