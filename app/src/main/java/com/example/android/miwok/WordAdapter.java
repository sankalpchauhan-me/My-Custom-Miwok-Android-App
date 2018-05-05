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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sankalp on 24/4/18.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     *Storing the color
     */
    private int mColorID;

    public WordAdapter(Activity context, ArrayList<Word> wordsToGet, int ColorID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordsToGet);
        mColorID= ColorID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word getPos = getItem(position);

        TextView translationDefault = (TextView) listItemView.findViewById(R.id.english_text);
        translationDefault.setText(getPos.getDefaultTranslation());

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text);
        miwokTranslation.setText(getPos.getMiwokTranslation());

        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.imagedef);
      if(getPos.hasImage()) {
          imageResource.setImageResource(getPos.getImageResourceID());
          imageResource.setVisibility(View.VISIBLE);
      }
      else{
          imageResource.setVisibility(View.GONE);
      }
        /**
         * Color getter
         */
        View listcolor = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorID);
        listcolor.setBackgroundColor(color);

        return listItemView;
    }
}
