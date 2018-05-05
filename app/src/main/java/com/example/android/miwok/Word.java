package com.example.android.miwok;

/**
 * Created by sankalp on 23/4/18.
 */

/**
        * {@link Word} represents a vocabulary word that the user wants to learn.
        * It contains a default translation and a Miwok translation for that word.
        */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /**Image resource ID */
    private int mImageResourceID = NO_IMAGE_IS_PRESENT ;

    public static final int NO_IMAGE_IS_PRESENT = -1;

    /**Audio ResourceId**/
    private int mAudioResourceID;

    /**
     * THIS IS THE CONSTRUCTOR FOR PHRASES ACTIVITY
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param AudioResourceID Gets the Audio
     */
    public Word(String defaultTranslation, String miwokTranslation, int AudioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = AudioResourceID;
    }
    /**
     * THIS IS THE SECOND CONSTRUCTOR WITH IMAGE ID
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param ImageResourceID is the integer position for the recieved Image
     * @param AudioResourceId is the integer position of recieved File
     */


    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceID, int AudioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = ImageResourceID;
        mAudioResourceID= AudioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Image Resource ID
     */
    public int getImageResourceID(){return mImageResourceID;}

    /**
     * Method check for the presence of image
     */
    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_IS_PRESENT;
    }
    /**
     * Method to get the audio resource Id
     */
    public int getmAudioResourceID(){
        return mAudioResourceID;
    }
}

