package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    EditText editText;
    Button btthem,btcapnhat;
    ArrayList<String> arrayList;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = (ListView) findViewById(R.id.listviewMonHoc);
        editText = (EditText) findViewById(R.id.edtext);
        btthem = (Button) findViewById(R.id.them);
        btcapnhat = (Button) findViewById(R.id.capnhat);
        arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Long list: " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = editText.getText().toString();
                arrayList.add(monhoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã thêm vào thành công", Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(arrayList.get(i));
                vitri = i;
            }
        });

        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(vitri, editText.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã cập nhật thành công", Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xoá thành công", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}