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

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    //holder help us to make code more efficiency
    MainActivity.ViewHolder holder;

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

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);
            holder = new MainActivity.ViewHolder();
            holder.currentSongArtist = (TextView) convertView.findViewById(R.id.artist_text_view);
            holder.currentSongName = (TextView) convertView.findViewById(R.id.song_text_view);
            holder.currentSongCover = (ImageView) convertView.findViewById(R.id.cover_image_view);
            holder.currentSongLong = (TextView) convertView.findViewById(R.id.song_long_text_view);
            convertView.setTag(holder);
        } else {
            holder = (MainActivity.ViewHolder) convertView.getTag();
        }
        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);
;
        holder.currentSongCover.setImageResource(currentSong.getCoverResourceId());
        holder.currentSongArtist.setText(currentSong.getArtist());
        holder.currentSongName.setText(currentSong.getSongName());
        holder.currentSongLong.setText(currentSong.getSongLongMinSec());

        return convertView;
    }



}
