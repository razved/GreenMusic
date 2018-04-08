package com.example.android.greenmusic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * constructor
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songArrayList A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songArrayList) {
        super(context, 0, songArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        View listSongView = convertView;
        if (listSongView == null) {
            listSongView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);
        }
        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);
        //Find the ImageView cover_image_view in the song_list.xml and set image by Resource Id
        ImageView coverResource = (ImageView) listSongView.findViewById(R.id.cover_image_view);
        coverResource.setImageResource(currentSong.getCoverResourceId());

        //Find the artist_text_view in the song_list.xml and set text of current Artist name
        TextView artist = (TextView) listSongView.findViewById(R.id.artist_text_view);
        artist.setText(currentSong.getArtist());

        //Find the song_text_view in the song_list.xml and set text of current Song name
        TextView song = (TextView) listSongView.findViewById(R.id.song_text_view);
        song.setText(currentSong.getSongName());

        //Find the song_long_text_view in the song_list.xml and set text of current song's long
        TextView songLong = (TextView) listSongView.findViewById(R.id.song_long_text_view);
        songLong.setText(currentSong.getSongLongMinSec());

        return listSongView;
    }



}
