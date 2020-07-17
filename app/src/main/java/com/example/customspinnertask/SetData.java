package com.example.customspinnertask;

import java.util.ArrayList;
import java.util.List;

public class SetData {
    public static List<IDisplay> getTestData() {
        List<IDisplay> data = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            data.add(new User("userNum " + i));

        return data;
    }
}
