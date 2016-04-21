package com.juliengenoud.easymessages.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juliengenoud.easymessages.fragments.ContactFragment;
import com.juliengenoud.easymessages.fragments.MessageFragment;

/**
 * Author : juliengenoud
 * 17/04/16
 **/
public class MessagesFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"CONTACT", "MESSAGES"};
    private Context context;

    public MessagesFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ContactFragment.newInstance();
            case 1:
                return MessageFragment.newInstance();
            case 2:
                return MessageFragment.newInstance();
            default:
                return ContactFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
