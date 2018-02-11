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

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_lists);
        final ArrayList<word> list = new ArrayList<word>();
        list.add(new word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        list.add(new word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        list.add(new word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        list.add(new word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        list.add(new word("older brother", "taachi", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        list.add(new word("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        list.add(new word("older sister", "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        list.add(new word("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        list.add(new word("grandmother ", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        list.add(new word("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, list, R.color.category_family);

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
                audio = MediaPlayer.create(FamilyActivity.this, audioWord.getmAudioID());
                audio.start();
            }
        });
    }
}
