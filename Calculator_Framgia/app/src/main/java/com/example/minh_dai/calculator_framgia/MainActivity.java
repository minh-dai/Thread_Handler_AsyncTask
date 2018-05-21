package com.example.minh_dai.calculator_framgia;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnDataPass{

    private String data = "";
    private SharedPreferences sharedPreferences ;
    private SharedPreferences.Editor editor;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MyFragment myFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        myFragment = new MyFragment();
        fragmentTransaction.add(R.id.fragment , myFragment);
        fragmentTransaction.commit();

    }

    private void initView() {

        sharedPreferences =
                getSharedPreferences("minh_dai", Context.MODE_PRIVATE);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemClear:
                onCLickClear();
                break;
            case R.id.itemSave:
                onCLickSave();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void onCLickClear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void onCLickSave() {

        if (!data.equals("")) {
            editor = sharedPreferences.edit();
            editor.putString("last" , data);
            editor.apply();

            Toast.makeText(MainActivity.this, "Da Luu :"
                    + sharedPreferences.getString("last","0"),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onDataPass(String data) {
        this.data = data;
    }
}
