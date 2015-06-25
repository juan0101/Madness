package br.com.madness.madness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class WinActivity extends ActionBarActivity {
    MediaPlayer audio;
    Integer controle_play_pause = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_madness);
        audio = MediaPlayer.create(this, R.raw.vamos_vamos);
        playMadness();
    }

    public void playMadness() {
        audio.start();
    }

    public void pauseMadness(View v) {
        Button botao = (Button) findViewById(R.id.BtnPause);
        if (controle_play_pause == 0) {
            audio.pause();
            controle_play_pause = 1;
            botao.setBackgroundResource(R.drawable.play_inicio);
        } else {
            audio.start();
            controle_play_pause = 0;
            botao.setBackgroundResource(R.drawable.pause_inicio);

        }

    }

    public void stopMadness(View v) {
        audio.stop();
        Intent tela = new Intent(this, MadnessGameActivity.class);
        startActivity(tela);
    }

}
