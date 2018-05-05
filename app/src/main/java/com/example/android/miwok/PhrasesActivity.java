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

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> arraynumbers = new ArrayList<Word>();
        arraynumbers.add(new Word("Where are you going?\n", "minto wuksus", R.raw.phrase_where_are_you_going));
        arraynumbers.add(new Word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        arraynumbers.add(new Word("My Name is...", "oyaaset...",R.raw.phrase_my_name_is));
        arraynumbers.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        arraynumbers.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        arraynumbers.add(new Word("Are u coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        arraynumbers.add(new Word("Yes, Im coming", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        arraynumbers.add(new Word("I am coming", "әәnәm", R.raw.phrase_im_coming));
        arraynumbers.add(new Word("Let's Go", "yoowutis",R.raw.phrase_lets_go));
        arraynumbers.add(new Word("Come here", "әnni'nem", R.raw.phrase_come_here));

        //ListView for view recyclying
        WordAdapter itemsAdapter = new WordAdapter(this, arraynumbers, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word pos = arraynumbers.get(position);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, pos.getmAudioResourceID());
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
        }
    }
}
