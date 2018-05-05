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
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
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
        arraynumbers.add(new Word("red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        arraynumbers.add(new Word("green","chokokki",R.drawable.color_green, R.raw.color_green));
        arraynumbers.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        arraynumbers.add(new Word("grey", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        arraynumbers.add(new Word("black", "kululli",R.drawable.color_black, R.raw.color_black));
        arraynumbers.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        arraynumbers.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        arraynumbers.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        //ListView for view recyclying
        WordAdapter itemsAdapter = new WordAdapter(this, arraynumbers, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word pos = arraynumbers.get(position);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, pos.getmAudioResourceID());
                mediaPlayer.start();
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
