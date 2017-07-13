package com.example.admin.bakingapp.RecipeChild;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.example.admin.bakingapp.R;
import com.example.admin.bakingapp.Recipe.Recipe;
import com.example.admin.bakingapp.RecipeChild.Instructions.Instruction;
import com.example.admin.bakingapp.RecipeDisplay.RecipeDisplayChildFragment;

/**
 * Created by Admin on 12-Jul-17.
 */

public class RecipeChild extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Flag determines if this is a one or two pane layout
    private boolean isTwoPane = false;

    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        // Call this to determine which layout we are in (tablet or phone)
        determinePaneLayout();
    }

    private void determinePaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.fragmentDetail);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
            isTwoPane = true;
        }

        if (isTwoPane){

            // Replace framelayout with new detail fragment
            RecipeChildFragment fragmentItem = new RecipeChildFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDetail, fragmentItem).commit();

        } else {

            //Get EXTRA from intent and attach to Fragment as Argument
            mRecipe = getIntent().getParcelableExtra("android.intent.extra.TITLE");

            Bundle args = new Bundle();

            args.putParcelable("ARGUMENTS", mRecipe);

            RecipeChildFragment recipeChildFragment = new RecipeChildFragment();
            recipeChildFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.recipeChildContainer, recipeChildFragment).commit();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
