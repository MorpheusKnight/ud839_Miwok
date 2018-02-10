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

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_lists);

        final ArrayList<word> list = new ArrayList<>();

        list.add(new word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        list.add(new word("Two", "oṭiiko", R.drawable.number_two, R.raw.number_two));
        list.add(new word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        list.add(new word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        list.add(new word("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        list.add(new word("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        list.add(new word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        list.add(new word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        list.add(new word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        list.add(new word("Ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, list, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word audioWord = list.get(position);
                audio = MediaPlayer.create(NumbersActivity.this, audioWord.getmAudioID());
                audio.start();
            }
        });
    }

}
