package com.zaptrapp.tmdbretrofit.RetroFit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishanth on 26/09/17.
 */

public class Movie implements Parcelable {

    @SerializedName("adult")
    public boolean adult;
    @SerializedName("backdrop_path")
    public String backdrop_path;
    @SerializedName("belongs_to_collection")
    public Belongs_to_collection belongs_to_collection;
    @SerializedName("budget")
    public int budget;
    @SerializedName("genres")
    public List<Genres> genres;
    @SerializedName("homepage")
    public String homepage;
    @SerializedName("id")
    public int id;
    @SerializedName("imdb_id")
    public String imdb_id;
    @SerializedName("original_language")
    public String original_language;
    @SerializedName("original_title")
    public String original_title;
    @SerializedName("overview")
    public String overview;
    @SerializedName("popularity")
    public double popularity;
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("production_companies")
    public List<Production_companies> production_companies;
    @SerializedName("production_countries")
    public List<Production_countries> production_countries;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("revenue")
    public int revenue;
    @SerializedName("runtime")
    public int runtime;
    @SerializedName("spoken_languages")
    public List<Spoken_languages> spoken_languages;
    @SerializedName("status")
    public String status;
    @SerializedName("tagline")
    public String tagline;
    @SerializedName("title")
    public String title;
    @SerializedName("video")
    public boolean video;
    @SerializedName("vote_average")
    public double vote_average;
    @SerializedName("vote_count")
    public int vote_count;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Belongs_to_collection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Belongs_to_collection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;

    }


    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Production_companies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Production_companies> production_companies) {
        this.production_companies = production_companies;
    }

    public List<Production_countries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Production_countries> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<Spoken_languages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Spoken_languages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public static class Belongs_to_collection {
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("poster_path")
        public String poster_path;
        @SerializedName("backdrop_path")
        public String backdrop_path;
    }

    public static class Genres {
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
    }

    public static class Production_companies {
        @SerializedName("name")
        public String name;
        @SerializedName("id")
        public int id;
    }

    public static class Production_countries {
        @SerializedName("iso_3166_1")
        public String iso_3166_1;
        @SerializedName("name")
        public String name;
    }

    public static class Spoken_languages {
        @SerializedName("iso_639_1")
        public String iso_639_1;
        @SerializedName("name")
        public String name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeString(this.backdrop_path);
        dest.writeParcelable((Parcelable) this.belongs_to_collection, flags);
        dest.writeInt(this.budget);
        dest.writeList(this.genres);
        dest.writeString(this.homepage);
        dest.writeInt(this.id);
        dest.writeString(this.imdb_id);
        dest.writeString(this.original_language);
        dest.writeString(this.original_title);
        dest.writeString(this.overview);
        dest.writeDouble(this.popularity);
        dest.writeString(this.poster_path);
        dest.writeList(this.production_companies);
        dest.writeList(this.production_countries);
        dest.writeString(this.release_date);
        dest.writeInt(this.revenue);
        dest.writeInt(this.runtime);
        dest.writeList(this.spoken_languages);
        dest.writeString(this.status);
        dest.writeString(this.tagline);
        dest.writeString(this.title);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeDouble(this.vote_average);
        dest.writeInt(this.vote_count);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.adult = in.readByte() != 0;
        this.backdrop_path = in.readString();
        this.belongs_to_collection = in.readParcelable(Belongs_to_collection.class.getClassLoader());
        this.budget = in.readInt();
        this.genres = new ArrayList<Genres>();
        in.readList(this.genres, Genres.class.getClassLoader());
        this.homepage = in.readString();
        this.id = in.readInt();
        this.imdb_id = in.readString();
        this.original_language = in.readString();
        this.original_title = in.readString();
        this.overview = in.readString();
        this.popularity = in.readDouble();
        this.poster_path = in.readString();
        this.production_companies = new ArrayList<Production_companies>();
        in.readList(this.production_companies, Production_companies.class.getClassLoader());
        this.production_countries = new ArrayList<Production_countries>();
        in.readList(this.production_countries, Production_countries.class.getClassLoader());
        this.release_date = in.readString();
        this.revenue = in.readInt();
        this.runtime = in.readInt();
        this.spoken_languages = new ArrayList<Spoken_languages>();
        in.readList(this.spoken_languages, Spoken_languages.class.getClassLoader());
        this.status = in.readString();
        this.tagline = in.readString();
        this.title = in.readString();
        this.video = in.readByte() != 0;
        this.vote_average = in.readDouble();
        this.vote_count = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
