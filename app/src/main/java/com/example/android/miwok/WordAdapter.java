package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by babyj on 1/29/2018.
 */

public class WordAdapter extends ArrayAdapter<word> {

    private int mResourceColor;

    public WordAdapter(Activity context, ArrayList<word> list, int ResourceColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, list);
        ResourceColor = mResourceColor;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        word current_word = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        miwokTextView.setText(current_word.getmMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(current_word.getmDefaultTranslation());

        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.image);

        if (current_word.hasImage()) {
            imageResource.setImageResource(current_word.getmImageResourcet());

            imageResource.setVisibility(View.VISIBLE);
        } else {
            imageResource.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.colorBackground);
        int color = ContextCompat.getColor(getContext(), mResourceColor);
        textContainer.setBackgroundColor(color);
        return listItemView;

    }

}
