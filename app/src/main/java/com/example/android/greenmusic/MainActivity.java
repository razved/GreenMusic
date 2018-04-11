package com.example.android.greenmusic;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static String NOTNOW = "I'm sorry, it's not working now :(";
    private Song currentSong;
    //Define variables
    private TextView currentSongArtist;
    private TextView currentSongName;
    private ImageView currentSongCover;
    //Index of current song in playlist
    private int indexOfSong;
    private Toast toast;
    //ViewHolder to improve efficiency of code
    static class ViewHolder {
        TextView currentSongArtist;
        TextView currentSongName;
        TextView currentSongLong;
        ImageView currentSongCover;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songsList = new ArrayList<Song>();
        songsList.add(new Song("Girl Gone Wild","Madonna", 223, R.drawable.madonna_mdna));
        songsList.add(new Song("Gang Bang","Madonna", 326,R.drawable.madonna_mdna));
        songsList.add(new Song("Living for Love", "Madonna", 218, R.drawable.madonna_rebel_heart));
        songsList.add(new Song("HeartBreakCity", "Madonna", 213, R.drawable.madonna_rebel_heart));
        songsList.add(new Song("Nobody Can Save Me", "Linkin Park", 224, R.drawable.linkinpark_one_more_light));
        songsList.add(new Song("Good Goodbye", "Linkin Park", 211, R.drawable.linkinpark_one_more_light));
        songsList.add(new Song("You’re My Heart, You’re My Soul","Modern Talking", 227, R.drawable.moderntalking_back_for_good));
        songsList.add(new Song("In 100 Years","Modern Talking", 232, R.drawable.moderntalking_back_for_good));

        //Set Current song to behave views
        currentSongArtist = (TextView) findViewById(R.id.current_artist_textview);
        currentSongName = (TextView) findViewById(R.id.current_song_textview);
        currentSongCover = (ImageView) findViewById(R.id.current_cover_image);

        //As default we set the first song in playlist as current song
        indexOfSong = 0;
        currentSong = songsList.get(indexOfSong);


        final SongAdapter songListAdapter = new SongAdapter(this, songsList);
        ListView songsListView = (ListView) findViewById(R.id.playlist);
        songsListView.setAdapter(songListAdapter);

        //Handle click on element in playlist and set that song as current
        songsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                currentSong = songListAdapter.getItem(position);

                showCurrentSong(currentSong);
                indexOfSong = position;
                openCurrentSongActivity();
            }
        });
        toast = Toast.makeText(getApplicationContext(), NOTNOW, Toast.LENGTH_SHORT);
        //handle click on album cover image and open CurrentSong Activity
        ImageView coverImage = (ImageView) findViewById(R.id.current_cover_image);

        coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrentSongActivity();
            }
        });

        //handle click on play button
        ImageView playButton = (ImageView) findViewById(R.id.play_button);
        playButton.setOnClickListener(this);
        //handle click on pause button
        ImageView pauseButton = (ImageView) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(this);

        ImageView nextButton = (ImageView) findViewById(R.id.next_track_button);
        nextButton.setOnClickListener(this);

        //handle click on previous button
        ImageView previousButton = (ImageView) findViewById(R.id.previous_track_button);
        previousButton.setOnClickListener(this);

        showCurrentSong(currentSong);

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

    private void openCurrentSongActivity() {
        Intent currentPlayIntent = new Intent(MainActivity.this, CurrentSongActivity.class);
        currentPlayIntent.putExtra("currentSongArtist", currentSong.getArtist());
        currentPlayIntent.putExtra("currentSongName", currentSong.getSongName());
        currentPlayIntent.putExtra("currentSongLong", currentSong.getSongLong());
        currentPlayIntent.putExtra("currentSongCover", currentSong.getCoverResourceId());
        startActivity(currentPlayIntent);
    }

    private void showCurrentSong(Song nowPlaying) {
        currentSongArtist.setText(nowPlaying.getArtist());
        currentSongName.setText(nowPlaying.getSongName());
        currentSongCover.setImageResource(nowPlaying.getCoverResourceId());
    }

}
