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

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_lists);
        final ArrayList<word> list = new ArrayList<>();
        list.add(new word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        list.add(new word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));
        list.add(new word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        list.add(new word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        list.add(new word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        list.add(new word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        list.add(new word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        list.add(new word("white", "kelelli", R.drawable.color_white, R.raw.color_white));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for(int index=0;index<list.size();index++){
//            TextView temp= new TextView(this);
//            temp.setText(list.get(index));
//            rootView.addView(temp);
//        }
        WordAdapter adapter = new WordAdapter(this, list, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word audioWord = list.get(position);
                audio = MediaPlayer.create(ColorsActivity.this, audioWord.getmAudioID());
                audio.start();
            }
        });
    }

}
