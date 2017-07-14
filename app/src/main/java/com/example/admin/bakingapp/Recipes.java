package com.example.admin.bakingapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.admin.bakingapp.RecipeChild.Ingredients.Ingredient;

/**
 * Created by Admin on 14-Jul-17.
 */

public class Recipes implements Parcelable{

    private Integer recipeId;
    private String recipeName;

    public Recipes() {

    }

    //RecipeName
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer id) {
        this.recipeId = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    //Ingredients
    private String ingredientName;
    private String ingredientMeasure;
    private Double ingredientQuantity;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String name) {
        this.ingredientName = name;
    }


    public String getIngredientMeasure() {
        return ingredientMeasure;
    }

    public void setIngredientMeasure(String measure) {
        this.ingredientMeasure = measure;
    }

    public Double getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(Double quantity) {
        this.ingredientQuantity = quantity;
    }

    //Instruction
    private String shortDescription;
    private String longDescription;
    private Integer id;
    private String videoURL;
    private String thumbnailURL;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Integer getInstructionId() {
        return id;
    }

    public void setInstructionId(Integer id) {
        this.id = id;
    }

    public String getThumbnailURL(){
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getVideoURL(){
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }


    protected Recipes(Parcel in) {
        recipeId = in.readInt();
        recipeName = in.readString();

        shortDescription = in.readString();
        longDescription = in.readString();
        id = in.readInt();
        videoURL = in.readString();
        thumbnailURL = in.readString();

        ingredientName = in.readString();
        ingredientMeasure = in.readString();
        ingredientQuantity = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(recipeId);
        dest.writeString(recipeName);

        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeInt(id);
        dest.writeString(videoURL);
        dest.writeString(thumbnailURL);

        dest.writeString(ingredientName);
        dest.writeString(ingredientMeasure);
        dest.writeDouble(ingredientQuantity);
    }


    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Recipes> CREATOR = new Parcelable.Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };



}
