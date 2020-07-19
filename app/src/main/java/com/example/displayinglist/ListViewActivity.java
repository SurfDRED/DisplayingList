package com.example.displayinglist;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity  {
    private static List<Map<String, String>> content = new ArrayList<>();
    private static SimpleAdapter simpleAdapter;
    private static ListView list;
    private static final String TITLE = "title";
    private static final String SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        list = findViewById(R.id.list);

        // игнорируем при повороте
        if(content.size() == 0){
            String[] title = prepareContent();
            Map<String, String> titleText;
            for (int i = 0; i < title.length; i++) {
                titleText = new HashMap<>();
                titleText.put(TITLE, title[i]);
                titleText.put(SUBTITLE, String.valueOf(title[i].length()));
                content.add(titleText);
            }
        }
        simpleAdapter = new SimpleAdapter(this, content, R.layout.block, new String[] {TITLE,SUBTITLE}, new int[] {R.id.top_block, R.id.bottom_block});
        list.setAdapter(simpleAdapter);
    }

    @NonNull
    private String[] prepareContent() {
        return getString(R.string.large_text).split("\n\n ");
    }
}