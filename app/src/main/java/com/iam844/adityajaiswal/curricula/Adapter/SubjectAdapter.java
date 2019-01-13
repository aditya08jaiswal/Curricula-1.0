package com.iam844.adityajaiswal.curricula.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;

import java.util.ArrayList;

public class SubjectAdapter extends ArrayAdapter {

    public SubjectAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.subject_item, null);
        }

        Subject currentSub = (Subject) getItem(position);

        TextView textView = view.findViewById(R.id.subject_textView);
        ImageView imageView = view.findViewById(R.id.subject_imageView);

        textView.setText(currentSub.getSubListName());
        imageView.setImageResource(currentSub.getSubListImage());

        return view;
    }
}
