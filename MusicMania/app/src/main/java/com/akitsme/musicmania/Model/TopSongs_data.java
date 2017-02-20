package com.akitsme.musicmania.Model;

/**
 * Created by AKASH on 20-02-2017.
 */

public class TopSongs_data {
    private String Title;
    private String songImage;
    private String artist_name;
    public TopSongs_data(String title,String image,String artist_name){
        this.Title=title;
        this.songImage=image;
        this.artist_name=artist_name;
    }

    public String getTitle() {
        return Title;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public String getSongImage() {
        return songImage;
    }
}
