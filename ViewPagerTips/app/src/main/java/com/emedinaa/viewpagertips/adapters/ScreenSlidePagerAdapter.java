package com.emedinaa.viewpagertips.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.emedinaa.viewpagertips.fragments.AFragment;
import com.emedinaa.viewpagertips.fragments.BFragment;
import com.emedinaa.viewpagertips.fragments.CFragment;
import com.emedinaa.viewpagertips.fragments.IFragment;


/**
 * Created by emedinaa on 21/11/15.
 */
public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    private static final String TAG ="ScreenSlidePagerAdapter" ;
    public static final int FRAG_A=0;
    public static final int FRAG_B=1;
    public static final int FRAG_C=2;
    private static final int NUM_PAGES = 3;


    private Fragment[] fragmentList;
    private String messageA;
    private String messageB;
    private String messageC;
    private FragmentManager fragmentManager;
    private AFragment aFragment= AFragment.newInstance(null,null);
    private BFragment bFragment= BFragment.newInstance(null,null);
    private CFragment cFragment= CFragment.newInstance(null,null);

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentManager=fm;
        fragmentList= new Fragment[NUM_PAGES];
        fragmentList[0]=aFragment;
        fragmentList[1]=bFragment;
        fragmentList[2]=cFragment;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case FRAG_A:
                fragmentList[position]= AFragment.newInstance(messageA,null);
                return fragmentList[position];
            case FRAG_B:
                fragmentList[position]= BFragment.newInstance(messageB,null);
                return fragmentList[position];
            case FRAG_C:
                fragmentList[position]= CFragment.newInstance(messageC,null);
                return fragmentList[position];
        }
        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


    public void updateFragment(int fragment, String message )
    {
        switch (fragment)
        {
            case FRAG_A:
                messageA= message;
                ((AFragment)fragmentList[fragment]).updateMessage(message);
                break;
            case FRAG_B:
                messageB= message;
                ((BFragment)fragmentList[fragment]).updateMessage(message);
                break;
            case FRAG_C:
                messageC= message;
                ((CFragment)fragmentList[fragment]).updateMessage(message);
                break;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
