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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_lists);
        final ArrayList<word> list = new ArrayList<word>();
        list.add(new word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        list.add(new word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        list.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        list.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        list.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        list.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        list.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        list.add(new word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        list.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        list.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, list, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word audioWord = list.get(position);
                audio = MediaPlayer.create(PhrasesActivity.this, audioWord.getmAudioID());
                audio.start();
            }
        });
    }
}
