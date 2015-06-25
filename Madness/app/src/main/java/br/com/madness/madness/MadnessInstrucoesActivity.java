package br.com.madness.madness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
/**
 * Created by Juan-Note on 30/05/2015.
 */
public class MadnessInstrucoesActivity extends ActionBarActivity implements MediaPlayer.OnCompletionListener {

    MediaPlayer audio;

    public void onCompletion(MediaPlayer mp) {
        Intent tela = new Intent(this, SalaDeEstarActivity.class);
        startActivity(tela);
    }

    public void playMadness(){
        audio.start();
        audio.setOnCompletionListener(this);
    }

    public void pularInstrucao(View v){
        audio.stop();
        Intent retorno = new Intent(this, SalaDeEstarActivity.class);
        startActivity(retorno);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madness_instrucao);
        audio = MediaPlayer.create(this, R.raw.explicacao);
        playMadness();

    }


}
