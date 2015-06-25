package br.com.madness.madness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class FimActivity extends ActionBarActivity {

    Integer controle_play_pause = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fim);
        }

    public void stopMadness(View v) {
        Intent tela = new Intent(this, MadnessGameActivity.class);
        startActivity(tela);
    }

}
