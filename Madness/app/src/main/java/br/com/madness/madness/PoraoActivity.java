package br.com.madness.madness;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.media.MediaPlayer.OnCompletionListener;


/**
 * Created by Juan-Note on 30/05/2015.
 *
 * Indice da classe = 4
 */
public class PoraoActivity extends ActionBarActivity implements OnCompletionListener {

    ListView lv;
    MediaPlayer audio;
    Integer controle_play_pause = 0;

    public void onCompletion(MediaPlayer mp) {
        Intent tela = new Intent(this, CasaDoAmigoActivity.class);
        startActivity(tela);
    }

    public void playMadness() {
        audio.start();
        audio.setOnCompletionListener(this);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.porao);
        lv = (ListView)findViewById(R.id.listView);
        audio = MediaPlayer.create(this, R.raw.porao);
        playMadness();
    }

}
