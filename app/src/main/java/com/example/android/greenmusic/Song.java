package com.example.android.greenmusic;


public class Song {
    //Song name
    private String mSongName;
    //Artist name
    private String mArtist;
    //Long of song in seconds
    private int mSongLong;
    //Picture of Album
    private int mCoverResourceId;

    public Song(String songName, String artist, int songLong, int albumPictureResource) {
        mSongName = songName;
        mArtist = artist;
        mSongLong = songLong;
        mCoverResourceId = albumPictureResource;
    }

    //return song name
    public String getSongName() {
        return mSongName;
    }
    //return Artist name
    public String getArtist() {
        return mArtist;
    }
    // return long of song in seconds
    public int getSongLong() {
        return mSongLong;
    }
    // return long of song in format min:sec
    public String getSongLongMinSec() {
        int min = mSongLong / 60;
        int sec = mSongLong % 60;
        String songLong = "" + min + ":" + sec;
        return songLong;
    }
    //return Id resource of album picture
    public int getCoverResourceId() {
        return mCoverResourceId;
    }

}
