package com.example.admin.bakingapp.RecipeChild;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.bakingapp.NetworkUtils;
import com.example.admin.bakingapp.R;
import com.example.admin.bakingapp.Recipe.Recipe;
import com.example.admin.bakingapp.Recipe.RecipeAdapter;
import com.example.admin.bakingapp.RecipeChild.Ingredients.Ingredient;
import com.example.admin.bakingapp.RecipeChild.Ingredients.IngredientAdapter;
import com.example.admin.bakingapp.RecipeChild.Ingredients.IngredientJSONData;
import com.example.admin.bakingapp.RecipeChild.Instructions.Instruction;
import com.example.admin.bakingapp.RecipeChild.Instructions.InstructionAdapter;
import com.example.admin.bakingapp.RecipeChild.Instructions.InstructionJSONData;
import com.example.admin.bakingapp.RecipeDisplay.RecipeDisplayChild;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class RecipeChild extends AppCompatActivity implements InstructionAdapter.InstructionAdapterOnClickHandler {

    private static final String SHARE = " #RecipeApp";

    String RECIPE_BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

    private Recipe mRecipe;

    private Toast mToast;

    private Context context;

    private IngredientAdapter mIngredientAdapter;
    private InstructionAdapter mInstructionAdapter;

    private Instruction mInstruction;

    private RecyclerView mIngredientRV;
    private RecyclerView mInstructionRV;


    public RecipeChild(Context clickHandler) {
        context = clickHandler;
    }

    public RecipeChild() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mIngredientRV = (RecyclerView) findViewById(R.id.ingredient_rv);
        mInstructionRV = (RecyclerView) findViewById(R.id.instruction_rv);

        GridLayoutManager gridIngredientManager = new GridLayoutManager(this, numberOfColumns());
        GridLayoutManager gridInstructionManager = new GridLayoutManager(this, numberOfColumns());

        mIngredientRV.setLayoutManager(gridIngredientManager);
        mInstructionRV.setLayoutManager(gridInstructionManager);

        mRecipe = getIntent().getParcelableExtra("android.intent.extra.TITLE");

        mIngredientAdapter = new IngredientAdapter();
        mIngredientRV.setAdapter(mIngredientAdapter);
        loadIngredientData();

        mInstructionAdapter = new InstructionAdapter(this, (InstructionAdapter.InstructionAdapterOnClickHandler) this);
        mInstructionRV.setAdapter(mInstructionAdapter);
        loadInstructionData();

    }

    /**
     * This method will load the ingredient
     */
    private void loadIngredientData() {
        new IngredientQueryTask().execute();
        showIngredientDataView();
    }

    /**
     * This method will load the instruction
     */
    private void loadInstructionData() {
        new InstructionQueryTask().execute();
        showInstructionDataView();
    }

    private void showIngredientDataView() {
        /* Make sure the recipe data is visible */
        mIngredientRV.setVisibility(View.VISIBLE);
    }

    private void showInstructionDataView() {
        /* Make sure the recipe data is visible */
        mIngredientRV.setVisibility(View.VISIBLE);
    }



    @Override
    public void onClick(Instruction instruction) {
        Context context = this;
        Class destinationClass = RecipeDisplayChild.class;
        Intent intentToStartDetailActivity = new Intent(context, destinationClass);
        intentToStartDetailActivity.putExtra(Intent.EXTRA_TITLE, instruction);
        startActivity(intentToStartDetailActivity);
    }


    public class IngredientQueryTask extends AsyncTask<String, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(String... params) {
            URL recipeSearchUrl = NetworkUtils.buildUrl(RECIPE_BASE_URL);
            try {
                String jsonRecipeResponse = NetworkUtils
                        .getResponseFromHttpUrl(recipeSearchUrl);

                ArrayList simpleJsonIngredientData = IngredientJSONData
                        .getIngredientDataStringsFromJson(RecipeChild.this, jsonRecipeResponse);

                return simpleJsonIngredientData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList ingredientData) {
            mIngredientAdapter.setIngredientData(ingredientData);
        }

    }


    public class InstructionQueryTask extends AsyncTask<String, Void, ArrayList> {

        @Override
        protected ArrayList doInBackground(String... params) {
            URL recipeSearchUrl = NetworkUtils.buildUrl(RECIPE_BASE_URL);
            try {
                String jsonRecipeResponse = NetworkUtils
                        .getResponseFromHttpUrl(recipeSearchUrl);

                ArrayList simpleJsonInstructionData = InstructionJSONData
                        .getInstructionDataStringsFromJson(RecipeChild.this, jsonRecipeResponse);

                return simpleJsonInstructionData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList instructionData) {
            mInstructionAdapter.setInstructionData(instructionData);
        }

    }

    private int numberOfColumns() {
        int nColumns = 1;
        return nColumns;
    }

}

