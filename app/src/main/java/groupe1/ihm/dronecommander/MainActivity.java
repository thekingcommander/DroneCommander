package groupe1.ihm.dronecommander;


import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;


import android.view.MotionEvent;
import android.widget.Button;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String PATH_NAME = "/storage/emulated/0/media/audio/son.wav";
    Button action = null;

    int sampleRateInHz = 44100;
    int channelconfig = AudioFormat.CHANNEL_IN_STEREO;
    int audioFormat = AudioFormat.ENCODING_PCM_8BIT;



    private OnTouchListener actionListener= new OnTouchListener(){
        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            ExtAudioRecorder recorder= new ExtAudioRecorder(true,MediaRecorder.AudioSource.DEFAULT,sampleRateInHz,channelconfig,audioFormat);
            recorder.setOutputFile(PATH_NAME);
            if (arg1.getAction()== MotionEvent.ACTION_DOWN){


                recorder.prepare();
                recorder.start();
                runEnregistrement();
            }

            else if (arg1.getAction()== MotionEvent.ACTION_UP){   recorder.stop();
                recorder.release();
                recorder.reset(); stopEnregistrement();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        action = (Button)findViewById(R.id.action);

        action.setOnTouchListener(actionListener);






    }



    private void runEnregistrement(){


    }

    private void stopEnregistrement(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
