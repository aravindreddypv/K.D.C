package quiz.kdc.neuromancers.kdc;

/**
 * Created by aravind on 8/30/2015.
 */import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by aravind on 8/9/2015.
 */
public class Slide extends FragmentPagerAdapter {
    ViewPager vp;
    public Slide(FragmentManager fm,ViewPager viewPager) {

        super(fm);
        vp=viewPager;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            return new prob1();

        }
        if(position==1)
        {
            return new prob2();
        }
        if(position==2)
        {
            return new prob3();
        }
        if(position==3)
        {
            return new prob4();
        }
        if(position==4)
        {
            return new prob5();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}

