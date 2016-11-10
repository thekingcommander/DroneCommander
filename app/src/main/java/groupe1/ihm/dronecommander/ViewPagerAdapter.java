package groupe1.ihm.dronecommander;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Guillaume on 09/11/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment result = viewFragment_animation.newInstance();
        ;
        switch (i) {
            case 0: {
                result = viewFragment_animation.newInstance();
                break;
            }
            case 1: {
                result = viewFragment_Commandes.newInstance();
                break;
            }
        }
        return result;
    }

    @Override
    public int getCount() {
        return 2;
    }
}