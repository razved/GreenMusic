package com.example.android.greenmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentSongActivity extends AppCompatActivity implements View.OnClickListener {

    final static String NOTNOW = "I'm sorry, it's not working now :(";
    private Song nowPlaying;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_song);
        Intent intent = getIntent();
        String artist = intent.getStringExtra("currentSongArtist");
        String song = intent.getStringExtra("currentSongName");
        int songLong = intent.getIntExtra("currentSongLong", -1);
        int songCover = intent.getIntExtra("currentSongCover", -1);
        nowPlaying = new Song(song, artist, songLong, songCover);

        toast = Toast.makeText(getApplicationContext(), NOTNOW, Toast.LENGTH_SHORT);

        //Show now playing song date
        TextView currentArtist = (TextView) findViewById(R.id.current_artist_textview);
        currentArtist.setText(nowPlaying.getArtist());

        TextView currentSongName = (TextView) findViewById(R.id.current_song_textview);
        currentSongName.setText(nowPlaying.getSongName());

        ImageView currentSongCover = (ImageView) findViewById(R.id.current_cover_image);
        currentSongCover.setImageResource(songCover);

        //React on click on PlayList button
        ImageView playListButton = (ImageView) findViewById(R.id.playlist_button);
        playListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //handle click on play button
        ImageView playButton = (ImageView) findViewById(R.id.play_button);
        playButton.setOnClickListener(this);

        //handle click on pause button
        ImageView pauseButton = (ImageView) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(this);

        //handle click on next button
        ImageView nextButton = (ImageView) findViewById(R.id.next_track_button);
        nextButton.setOnClickListener(this);

        //handle click on previous button
        ImageView previousButton = (ImageView) findViewById(R.id.previous_track_button);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_button:
                toast.show();
                break;
            case R.id.pause_button:
                toast.show();
                break;
            case R.id.next_track_button:
                toast.show();
                break;
            case R.id.previous_track_button:
                toast.show();
                break;
            default:
                break;
        }
    }
}
