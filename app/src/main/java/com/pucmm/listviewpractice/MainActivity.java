package com.pucmm.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvMain);

        List<String> list = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        list.add("Intel Core i3 10100");
        list.add("Intel Core i5 10400");
        list.add("Intel Core i7 10700");
        list.add("Intel Core i9 10900");

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            intent.putExtra("Item", parent.getAdapter().getItem(position).toString());
            startActivity(intent);
        });
    }
}