package groupe1.ihm.dronecommander;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Guillaume on 09/11/2016.
 */

public class viewFragment_animation  extends Fragment {

    public static Fragment newInstance() {
        viewFragment_animation instance;
        instance = new viewFragment_animation();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.viewpager_animation, container, false);
        ImageView img = (ImageView) rootView.findViewById(R.id.anim_test);
        img.setBackgroundResource(R.drawable.anim_test);

        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        frameAnimation.start();
        return rootView;
    }

}