package com.example.android_javai_project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStart = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonStart = (Button) findViewById(R.id.buttonStart);
        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the game.
                startGame();
            }
        });
    }

    private void startGame() {
        // TO-DO: Start the game (start the question activity).

                Intent intent = new Intent(MainActivity.this,
                        com.example.android_javai_project1.QuizActivity.class);
                startActivity(intent);
    }
}
