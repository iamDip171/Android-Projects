package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    // 0 -> O
    // 1 -> X
    // 2 -> null cell
    TextView scorePl1, scorePl2, player1, player2 ;
    LinearLayout layoutP1, layoutP2 ;

    int activePlayer = 0 ;
    int[] gridStates = {2, 2, 2, 2, 2, 2, 2, 2, 2} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent() ;
        player1 = findViewById(R.id.player1) ;
        player2 = findViewById(R.id.player2) ;
        String name1 = intent.getStringExtra(MainActivity.key1) ;
        String name2 = intent.getStringExtra(MainActivity.key2) ;

        player1.setText(name1);
        player2.setText(name2);

        LinearLayout layoutP1 = findViewById(R.id.linearLayout3) ;
        layoutP1.setBackgroundResource(R.drawable.playerturn);
    }

    public void playerTurn (View view) {
        layoutP1 = findViewById(R.id.linearLayout3) ;
        layoutP2 = findViewById(R.id.linearLayout2) ;
        ImageView img = (ImageView) view ;
        int tappedGrid = Integer.parseInt(img.getTag().toString()) ;

        if (gridStates[tappedGrid] == 2) {
            gridStates[tappedGrid] = activePlayer ;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.circle);
                activePlayer = 1 ;
                layoutP2.setBackgroundResource(R.drawable.playerturn);
                layoutP1.setBackgroundResource(R.drawable.rectangle_2);
            } else if (activePlayer == 1) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 0 ;
                layoutP1.setBackgroundResource(R.drawable.playerturn);
                layoutP2.setBackgroundResource(R.drawable.rectangle_2);
            }
        }

        if ( (gridStates[0] == 0 && gridStates[1] == 0 && gridStates[2] == 0) ||
                (gridStates[3] == 0 && gridStates[4] == 0 && gridStates[5] == 0) ||
                (gridStates[6] == 0 && gridStates[7] == 0 && gridStates[8] == 0) ||
                (gridStates[0] == 0 && gridStates[4] == 0 && gridStates[8] == 0) ||
                (gridStates[2] == 0 && gridStates[4] == 0 && gridStates[6] == 0) ||
                (gridStates[0] == 0 && gridStates[3] == 0 && gridStates[6] == 0) ||
                (gridStates[1] == 0 && gridStates[4] == 0 && gridStates[7] == 0) ||
                (gridStates[2] == 0 && gridStates[5] == 0 && gridStates[8] == 0)

        ) {
            for (int i=0; i<9; i++) gridStates[i] = 3 ;
            scorePl1 = findViewById(R.id.scoreP1) ;
            scorePl1.setText(String.valueOf(Integer.parseInt(scorePl1.getText().toString())+1));
            layoutP2.setBackgroundResource(R.drawable.rectangle_2);
            Toast.makeText(this, player1.getText().toString() + " WON", Toast.LENGTH_SHORT).show();
        }

        if ( (gridStates[0] == 1 && gridStates[1] == 1 && gridStates[2] == 1) ||
                (gridStates[3] == 1 && gridStates[4] == 1 && gridStates[5] == 1) ||
                (gridStates[6] == 1 && gridStates[7] == 1 && gridStates[8] == 1) ||
                (gridStates[0] == 1 && gridStates[4] == 1 && gridStates[8] == 1) ||
                (gridStates[2] == 1 && gridStates[4] == 1 && gridStates[6] == 1) ||
                (gridStates[0] == 1 && gridStates[3] == 1 && gridStates[6] == 1) ||
                (gridStates[1] == 1 && gridStates[4] == 1 && gridStates[7] == 1) ||
                (gridStates[2] == 1 && gridStates[5] == 1 && gridStates[8] == 1)

        ) {
            for (int i=0; i<9; i++) gridStates[i] = 3 ;
            scorePl2 = findViewById(R.id.scoreP2) ;
            scorePl2.setText(String.valueOf(Integer.parseInt(scorePl2.getText().toString())+1));
            layoutP1.setBackgroundResource(R.drawable.rectangle_2);
            Toast.makeText(this, player2.getText().toString() + " WON", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetBtn (View view) {
        layoutP1.setBackgroundResource(R.drawable.playerturn);
        layoutP2.setBackgroundResource(R.drawable.rectangle_2);
        activePlayer = 0 ;
        ImageView[] img = new ImageView[9] ;

        img[0] = findViewById(R.id.imageView01) ;
        img[1] = findViewById(R.id.imageView02) ;
        img[2] = findViewById(R.id.imageView03) ;
        img[3] = findViewById(R.id.imageView04) ;
        img[4] = findViewById(R.id.imageView05) ;
        img[5] = findViewById(R.id.imageView06) ;
        img[6] = findViewById(R.id.imageView07) ;
        img[7] = findViewById(R.id.imageView08) ;
        img[8] = findViewById(R.id.imageView09) ;


        for (int i=0; i<9; i++) {
            img[i].setImageResource(android.R.color.transparent);
            gridStates[i] = 2 ;
        }
    }

    public void playAgain (View view) {
        resetBtn(view);
        scorePl2 = findViewById(R.id.scoreP2) ;
        scorePl1 = findViewById(R.id.scoreP1) ;
        scorePl1.setText("0");
        scorePl2.setText("0");
    }
}