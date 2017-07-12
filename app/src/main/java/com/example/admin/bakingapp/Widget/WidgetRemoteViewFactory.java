package com.example.admin.bakingapp.Widget;

import android.content.Context;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.admin.bakingapp.RecipeChild.Ingredients.Ingredient;

import java.util.ArrayList;

/**
 * Created by Admin on 11-Jul-17.
 */

public class WidgetRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {

    Context mContext;
    private ArrayList<Ingredient> mIngredient;

    public WidgetRemoteViewFactory(Context applicationContext) {
        mContext = applicationContext;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {



    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        return null;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

}
