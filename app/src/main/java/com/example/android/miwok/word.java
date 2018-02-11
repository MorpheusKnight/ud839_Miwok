package com.example.android.miwok;

/**
 * Created by babyj on 10/30/2017.
 */

public class word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResource = NO_IMAGE_PROVIDED;
    private int mAudioID;

    public word(String DefaultTranslation, String MiwokTranslation, int ImageResource, int audioResource) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResource = ImageResource;
        mAudioID = audioResource;
    }

    public word(String DefaultTranslation, String MiwokTranslation, int audioResource) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioID = audioResource;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourcet() {
        return mImageResource;
    }

    public int getmAudioID() {
        return mAudioID;
    }

    public boolean hasImage() {

        return mImageResource != NO_IMAGE_PROVIDED;

    }
}
