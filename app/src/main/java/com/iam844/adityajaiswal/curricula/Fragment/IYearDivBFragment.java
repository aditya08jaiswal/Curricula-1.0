package com.iam844.adityajaiswal.curricula.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iam844.adityajaiswal.curricula.R;

public class IYearDivBFragment extends Fragment {

    public IYearDivBFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.timetable_fragment_image, container, false);

        ImageView image = rootView.findViewById(R.id.timetable_image);
        image.setImageResource(R.drawable.year1b);

        return rootView;
    }
}
