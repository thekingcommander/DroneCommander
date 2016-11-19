package groupe1.ihm.dronecommander;

import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Guillaume on 18/11/2016.
 */

public class Popup_Save  extends Activity {

    private Button boutonEnregistrer;
    private Button boutonAnnuler;
    private EditText editTextName;

    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_save);

        // gestion affichage sur une partie de l'ecran
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4));

        init_ButtonEnregistrer();

        init_ButtonAnnuler();

    }

    private void init_ButtonEnregistrer(){
        boutonEnregistrer = (Button) findViewById(R.id.button_saveenregistrer);

        boutonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName = (EditText) findViewById(R.id.editText_save);
                filename = editTextName.getText().toString();

                if(!verificationNom(filename)) {

                    Toast.makeText(getApplicationContext(), "Nom invalide", Toast.LENGTH_SHORT).show();

                } else {

                    MainActivity.copyWaveFile(
                            MainActivity.getFilename(MainActivity.AUDIO_RECORDER_FILE_EXT_WAV),
                            MainActivity.getFilename(filename));
                    Toast.makeText(getApplicationContext(), "Fichier enregistré", Toast.LENGTH_SHORT).show();
                    fermer();

                }
            }
        });
    }

    private void init_ButtonAnnuler(){
        boutonAnnuler = (Button) findViewById(R.id.button_saveannuler);

        boutonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fermer();
            }
        });
    }

    /**
     * verification du nom donnée par l'utilisateur
     * @param nom
     * @return boolean
     */
    private boolean verificationNom(String nom){
        if (nom.equals(MainActivity.AUDIO_RECORDER_FILE_EXT_WAV)){
            return false;
        }
        if(nom.equals("")){
            return false;
        }
        return true;
    }

    private void fermer() {
        this.finish();
    }

}
