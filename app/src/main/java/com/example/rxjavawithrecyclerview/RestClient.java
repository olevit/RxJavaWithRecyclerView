package com.example.rxjavawithrecyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RestClient {
    private Context mContext;

    public RestClient(Context context) {
        mContext = context;
    }

    public List<String> getCatNames() {
        try {
            // Имитируем задержки сети
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setNameList();
    }

    public List<String> getCatNamesWithException() {
        try {
            // Имитируем задержки сети
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Ошибка при загрузке данных");
    }

    private List<String> setNameList() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Васька");
        names.add("Барсик");
        names.add("Мурзик");
        names.add("Рыжик");
        names.add("Пушок");
        names.add("Снежок");
        names.add("Бублик");
        names.add("Тимоха");
        names.add("Кот 1");
        names.add("Кот 2");
        names.add("Кот 3");
        names.add("Кот 4");
        names.add("Кот 5");

        return names;
    }
}
