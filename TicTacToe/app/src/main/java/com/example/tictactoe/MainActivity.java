package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String key1 = "mainKey" ;
    public static final String key2 = "secondKey" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void letsGo (View view) {
        Intent intent = new Intent(this, GameActivity.class) ;
        EditText play1 = findViewById(R.id.player01) ;
        EditText play2 = findViewById(R.id.player02) ;

        String name1 = play1.getText().toString() ;
        String name2 = play2.getText().toString() ;

        intent.putExtra(key1, name1) ;
        intent.putExtra(key2, name2) ;

        startActivity(intent);
    }

}