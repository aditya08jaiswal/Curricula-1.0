package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iam844.adityajaiswal.curricula.Fragment.CSE4Fragment;
import com.iam844.adityajaiswal.curricula.Fragment.ECE4Fragment;
import com.iam844.adityajaiswal.curricula.R;

public class BranchAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public BranchAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new CSE4Fragment();
        } else {
            return new ECE4Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.CSE);
        } else {
            return mContext.getString(R.string.ECE);
        }
    }
}
