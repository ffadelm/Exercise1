package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private ListView list;
    private ListViewAdapter adapter;
    EditText searchView;

    String[] listNama;

    public  static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Anang", "Badrul", "Cecep", "Dodit",
                "Ewing", "Fadel", "Gopal", "Hamdani", "Iwan", "Jamal"};

        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        searchView = findViewById(R.id.searchView);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Home.this).adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nama = classNamaArrayList.get(position).getNama();
                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Home.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                switch (bundle.getString("a")){
                    case "Anang":
                        Toast.makeText(getApplicationContext(), "081234567890",Toast.LENGTH_LONG).show();
                        break;
                    case "Badrul":
                        Toast.makeText(getApplicationContext(), "087898745678",Toast.LENGTH_LONG).show();
                        break;
                    case "Cecep":
                        Toast.makeText(getApplicationContext(), "081209876543",Toast.LENGTH_LONG).show();
                        break;
                    case "Dodit":
                        Toast.makeText(getApplicationContext(), "087812345680",Toast.LENGTH_LONG).show();
                        break;
                    case "Ewing":
                        Toast.makeText(getApplicationContext(), "083489682749",Toast.LENGTH_LONG).show();
                        break;
                    case "Fadel":
                        Toast.makeText(getApplicationContext(), "082176515234",Toast.LENGTH_LONG).show();
                        break;
                    case "Gopal":
                        Toast.makeText(getApplicationContext(), "081426739204",Toast.LENGTH_LONG).show();
                        break;
                    case "Hamdani":
                        Toast.makeText(getApplicationContext(), "089623419980",Toast.LENGTH_LONG).show();
                        break;
                    case "Iwan":
                        Toast.makeText(getApplicationContext(), "089678787244",Toast.LENGTH_LONG).show();
                        break;
                    case "Jamal":
                        Toast.makeText(getApplicationContext(), "081369356254",Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }
        return false;
    }
}