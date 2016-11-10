package groupe1.ihm.dronecommander;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Guillaume on 09/11/2016.
 */

public class viewFragment_Commandes extends Fragment {
    public static Fragment newInstance() {
        viewFragment_Commandes instance;
        instance = new viewFragment_Commandes();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpager_commande, container, false);
    }
}
