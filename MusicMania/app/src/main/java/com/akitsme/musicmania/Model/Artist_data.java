package com.akitsme.musicmania.Model;

/**
 * Created by AKASH on 19-02-2017.
 */

public class Artist_data {
    private String mArtist_Image_link;
    private String mArtist_name;

   public Artist_data(String name,String image){
        this.mArtist_Image_link=image;
        this.mArtist_name=name;
    }

    public String getmArtist_Image_link() {
        return mArtist_Image_link;
    }

    public String getmArtist_name() {
        return mArtist_name;
    }
}
