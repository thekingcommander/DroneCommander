package groupe1.ihm.dronecommander;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by Guillaume on 14/11/2016.
 */

public class ActivitySettings extends AppCompatActivity {

    private CheckBox volume;

    private SharedPreferences.Editor edit;
    private SharedPreferences preferences;

    private Button retour;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        retour = (Button) findViewById(R.id.retour);

        preferences = getDefaultSharedPreferences(getApplicationContext());
        volume = (CheckBox) findViewById(R.id.volume);

        volume.setChecked(preferences.getBoolean("volume",true));

        volume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                edit = preferences.edit();
                edit.putBoolean("volume",volume.isChecked());
                edit.apply();
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
