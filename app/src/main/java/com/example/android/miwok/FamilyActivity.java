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

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
        arraynumbers.add(new Word("father", "әpә",R.drawable.family_father, R.raw.family_father));
        arraynumbers.add(new Word("mother","әṭa", R.drawable.family_mother, R.raw.family_mother));
        arraynumbers.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        arraynumbers.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        arraynumbers.add(new Word("older brother", "aati", R.drawable.family_older_brother, R.raw.family_older_brother));
        arraynumbers.add(new Word("younger brother", "chaaliti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        arraynumbers.add(new Word("older sister", "tete", R.drawable.family_older_sister,R.raw.family_older_sister));
        arraynumbers.add(new Word("younger sister", "koliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        arraynumbers.add(new Word("grandmother", "amma", R.drawable.family_grandmother, R.raw.family_grandmother));
        arraynumbers.add(new Word("grandfather", "papa", R.drawable.family_grandfather, R.raw.family_grandfather));

        //ListView for view recyclying
        WordAdapter itemsAdapter = new WordAdapter(this, arraynumbers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                Word pos = arraynumbers.get(position);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, pos.getmAudioResourceID());
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
