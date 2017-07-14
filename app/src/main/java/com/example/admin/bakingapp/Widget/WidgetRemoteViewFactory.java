package com.example.admin.bakingapp.Widget;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.admin.bakingapp.R;
import com.example.admin.bakingapp.RecipeChild.Ingredients.Ingredient;

import java.util.List;

/**
 * Created by Admin on 11-Jul-17.
 */

public class WidgetRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory {

    Context mContext;
    List<Ingredient> mIngredient;

    Intent intent = new Intent();

    public WidgetRemoteViewFactory(Context applicationContext) {
        mContext = applicationContext;
    }

    @Override
    public void onCreate() {
        mIngredient = intent.getParcelableExtra("android.intent.extra.TITLE");
    }

    @Override
    public void onDataSetChanged() {
        mIngredient = intent.getParcelableExtra("android.intent.extra.TITLE");
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

        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_list_layout);



        // Set ingredients in the widget



        return remoteViews;
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
