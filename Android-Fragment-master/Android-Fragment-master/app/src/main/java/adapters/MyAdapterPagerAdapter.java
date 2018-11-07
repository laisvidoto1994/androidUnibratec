package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.fragments.Fragment_DetalheStudante;
import layout.fragments.Fragment_ListaStudantes;

public class MyAdapterPagerAdapter extends FragmentPagerAdapter
{
    private String[] mTabTitles;

    public MyAdapterPagerAdapter(FragmentManager fm, String[] mTabTitles)
    {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new Fragment_ListaStudantes();
            case 1:
                return  new Fragment_DetalheStudante();
            case 2:
                return null;
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return this.mTabTitles[position];
    }
}
