package br.com.madness.madness;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ListView;

import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Created by Juan-Note on 30/05/2015.
 *
 * Indice da classe = 7
 */
public class DormitorioActivity extends ActionBarActivity implements OnCompletionListener  {

    ListView lv;
    static final int check = 1111;
    String palavra;
    MediaPlayer audio;
    Integer controle_play_pause = 0;

    public void onCompletion(MediaPlayer mp) {
        audio.stop();
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale agora");
        startActivityForResult(i, check);
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        if (requestCode == check && resultCode == RESULT_OK) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            palavra = results.get(0);
            lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
        }
        super.onActivityResult(requestCode, resultCode, data);
        palavra = removeAcentos(palavra);
        if (palavra.equals("sim")) {
            respSim();
        } else if (palavra.equals("nao")) {
            respNao();
        } else {
            showSimplePopUp();
        }
    }



    public String removeAcentos(String str) {

        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;

    }

    private void showSimplePopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Resposta Incorreta");
        helpBuilder.setMessage("Responda Sim ou Nao");
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        onCompletion(audio);
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

    public void respSim() {
        Intent tela = new Intent(this, CozinhaActivity.class);
        startActivity(tela);    }

    public void respNao() {
        Intent telaNao = new Intent(this, QuartoActivity.class);
        startActivity(telaNao);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dormitorio);
        lv = (ListView)findViewById(R.id.listView);
        audio = MediaPlayer.create(this, R.raw.vamos_vamos);
        playMadness();
    }

}
