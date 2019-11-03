package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<User> list = new ArrayList<>();

    public Data() {
        for (int i = 0; i < 100; i++)
            list.add(new User("pes " + i, i, "https://media.tvzvezda.ru/news/vstrane_i_mire/content/201808261603-xg2y.htm/1.jpg"));
    }
}
