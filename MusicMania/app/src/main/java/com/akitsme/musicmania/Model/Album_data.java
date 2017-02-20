package com.akitsme.musicmania.Model;

/**
 * Created by AKASH on 20-02-2017.
 */

public class Album_data {
        private String Title;
        private String songImage;
        private String artist_name;
        public Album_data(String title,String image,String artist_name){
            this.Title=title;
            this.songImage=image;
            this.artist_name=artist_name;
        }

        public String getAlbumTitle() {
            return Title;
        }

        public String getArtist_name() {
            return artist_name;
        }

        public String getAlbumImage() {
            return songImage;
        }
    }

