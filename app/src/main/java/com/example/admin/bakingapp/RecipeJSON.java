package com.example.admin.bakingapp;

import android.content.Context;

import com.example.admin.bakingapp.Recipe.Recipe;
import com.example.admin.bakingapp.RecipeChild.Ingredients.Ingredient;
import com.example.admin.bakingapp.RecipeChild.Instructions.Instruction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Admin on 14-Jul-17.
 */

public class RecipeJSON {

    /**
     * @param recipeJsonStr JSON response from server
     * @return Array of Strings describing recipe data
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static ArrayList<Recipe> getRecipeDataStringsFromJson(Context context, String recipeJsonStr)
            throws JSONException {

        /* Main information information needed to display */
        final String RECIPE_TITLE = "name";
        final String RECIPE_ID = "id";

        /* Instruction information */
        final String INSTRUCTION_LIST = "steps";
        /* Main information information needed to display */
        final String INSTRUCTION_SHORT_DESCRIPTION = "shortDescription";
        final String INSTRUCTION_LONG_DESCRIPTION = "description";
        final String INSTRUCTION_ID = "id";
        final String INSTRUCTION_VIDEO = "videoURL";
        final String INSTRUCTION_IMAGE = "thumbnailURL";

        /* Recipe information */
        final String INGREDIENT_LIST = "ingredients";
        /* Main information information needed to display */
        final String INGREDIENT_NAME = "ingredient";
        final String INGREDIENT_MEASURE = "measure";
        final String INGREDIENT_QUANTITY = "quantity";


        JSONArray recipeJSON = new JSONArray(recipeJsonStr);

        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
        ArrayList<Instruction> instructionList = new ArrayList<Instruction>();
        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

        for (int i = 0; i < recipeJSON.length(); i++) {

            Recipe recipe = new Recipe();

            /* These are the values that will be collected */
            String recipeTitle;
            int recipeId;

            /* Get the JSON object for the recipe */
            JSONObject recipeObject = recipeJSON.getJSONObject(i);

            JSONArray ingredientArray = recipeObject.getJSONArray(INGREDIENT_LIST);

            for (int x = 0; x < ingredientArray.length(); x++) {

                Ingredient ingredient = new Ingredient();

                /* These are the values that will be collected */
                String ingredientName;
                String ingredientMeasure;
                Double ingredientQuantity;

                /* Get the JSON object for the movie */
                JSONObject ingredientObject = ingredientArray.getJSONObject(x);

                // Extract relevant JSON fields
                ingredientName = ingredientObject.getString(INGREDIENT_NAME);
                ingredientMeasure = ingredientObject.getString(INGREDIENT_MEASURE);
                ingredientQuantity = ingredientObject.getDouble(INGREDIENT_QUANTITY);

                ingredient.setIngredientName(ingredientName);
                ingredient.setIngredientMeasure(ingredientMeasure);
                ingredient.setIngredientQuantity(ingredientQuantity);

                ingredientList.add(ingredient);

            }


            // Extract relevant JSON fields
            recipeTitle = recipeObject.getString(RECIPE_TITLE);
            recipeId = recipeObject.getInt(String.valueOf(RECIPE_ID));

            recipe.setRecipeName(recipeTitle);
            recipe.setRecipeId(recipeId);

            recipeList.add(recipe);
        }



        return recipeList;
    }


}
