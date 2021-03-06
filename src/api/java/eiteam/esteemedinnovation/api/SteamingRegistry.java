package eiteam.esteemedinnovation.api;

import eiteam.esteemedinnovation.api.util.ItemStackUtility;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class SteamingRegistry {
    /**
     * All of the custom steaming recipes for the Steam Heater. These recipes will replace existing smelting recipes.
     * <p>
     * Key: input, Value: output
     */
    private static HashMap<ItemStack, ItemStack> steamingRecipes = new HashMap<>();

    /**
     * Adds a steaming custom recipe (not a replacement recipe).
     * @param input The input ItemStack
     * @param output The output ItemStack
     */
    public static void addSteamingRecipe(@Nonnull ItemStack input, @Nonnull ItemStack output) {
        steamingRecipes.put(input, output);
    }

    /**
     * Removes a steaming custom recipe (not a replacement recipe).
     * @param input The input ItemStack.
     */
    public static void removeSteamingRecipe(@Nonnull ItemStack input) {
        steamingRecipes.remove(input);
    }

    /**
     * Gets the steaming result for the given item. If there is no steaming recipe, returns the result of
     * {@link FurnaceRecipes#getSmeltingResult}.
     */
    public static ItemStack getSteamingResult(@Nonnull ItemStack input) {
        ItemStack steaming = getSteamingResultNoSmelting(input);
        return steaming == null ? FurnaceRecipes.instance().getSmeltingResult(input) : steaming;
    }

    /**
     * Gets the steaming result for the given item. If there is no steaming recipe, returns null.
     */
    public static ItemStack getSteamingResultNoSmelting(@Nonnull ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack> entry : steamingRecipes.entrySet()) {
            if (ItemStackUtility.compareItemStacks(input, entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
