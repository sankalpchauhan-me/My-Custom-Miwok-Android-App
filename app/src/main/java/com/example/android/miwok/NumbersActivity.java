/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mp;
    private int pos;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> arraynumbers = new ArrayList<Word>();
        arraynumbers.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        arraynumbers.add(new Word("two","otiiko", R.drawable.number_two, R.raw.number_two));
        arraynumbers.add(new Word("three", "tolookosu",R.drawable.number_three, R.raw.number_three));
        arraynumbers.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        arraynumbers.add(new Word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        arraynumbers.add(new Word("six", "temmoka", R.drawable.number_six, R.raw.number_six));
        arraynumbers.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        arraynumbers.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        arraynumbers.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        arraynumbers.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        //ListView for view recyclying
        WordAdapter itemsAdapter = new WordAdapter(this, arraynumbers, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {   // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                Word pos = arraynumbers.get(position);
                mp= MediaPlayer.create(NumbersActivity.this, pos.getmAudioResourceID());
                mp.start();
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mp.setOnCompletionListener(mCompletionListener);
            }
        });
    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }

}

