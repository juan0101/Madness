package br.com.madness.madness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MadnessGameActivity extends ActionBarActivity  {


    /*public void onClick(View v){

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale agora");
        startActivityForResult(i, check);

    }


    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode == check && resultCode == RESULT_OK){
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            palavra = results.get(0);
            lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));

        }
        super.onActivityResult(requestCode, resultCode, data);
        palavra = removeAcentos(palavra);
        if (palavra.equals("sim")){
            playSim();
        }else if(palavra.equals("nao")){
            playNao();
        }else {
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
        helpBuilder.setMessage("Responda Sim ou N�o");
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madness_game);

    }

    public void playMadness(View v){
        Intent controllerPlayer = new Intent(this, MadnessInstrucoesActivity.class);
        startActivity(controllerPlayer);
    }

}
