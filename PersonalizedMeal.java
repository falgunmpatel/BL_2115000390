import java.util.ArrayList;
import java.util.List;

interface MealPlan {
  void displayMeal();
}

class VegetarianMeal implements MealPlan {
  private String mealName;

  public VegetarianMeal(String mealName) {
    this.mealName = mealName;
  }

  @Override
  public void displayMeal() {
    System.out.println("Vegetarian Meal: " + mealName);
  }
}

class VeganMeal implements MealPlan {
  private String mealName;

  public VeganMeal(String mealName) {
    this.mealName = mealName;
  }

  @Override
  public void displayMeal() {
    System.out.println("Vegan Meal: " + mealName);
  }
}

class KetoMeal implements MealPlan {
  private String mealName;

  public KetoMeal(String mealName) {
    this.mealName = mealName;
  }

  @Override
  public void displayMeal() {
    System.out.println("Keto Meal: " + mealName);
  }
}

class HighProteinMeal implements MealPlan {
  private String mealName;

  public HighProteinMeal(String mealName) {
    this.mealName = mealName;
  }

  @Override
  public void displayMeal() {
    System.out.println("High-Protein Meal: " + mealName);
  }
}

class Meal<T extends MealPlan> {
  private List<T> mealList = new ArrayList<>();

  public void addMeal(T meal) {
    mealList.add(meal);
  }

  public List<T> getMeals() {
    return mealList;
  }
}

class MealPlanGenerator {
  public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
    System.out.println("\nGenerated Personalized Meal Plan:");
    for (T meal : meals) {
      meal.displayMeal();
    }
  }
}

public class PersonalizedMeal {
  public static void main(String[] args) {

    Meal<VegetarianMeal> vegetarianPlan = new Meal<>();
    vegetarianPlan.addMeal(new VegetarianMeal("Grilled Veggie Wrap"));
    vegetarianPlan.addMeal(new VegetarianMeal("Vegetable Stir Fry"));

    Meal<VeganMeal> veganPlan = new Meal<>();
    veganPlan.addMeal(new VeganMeal("Tofu Salad"));
    veganPlan.addMeal(new VeganMeal("Vegan Smoothie"));

    Meal<KetoMeal> ketoPlan = new Meal<>();
    ketoPlan.addMeal(new KetoMeal("Grilled Salmon with Avocado"));
    ketoPlan.addMeal(new KetoMeal("Cheese and Nuts"));

    Meal<HighProteinMeal> highProteinPlan = new Meal<>();
    highProteinPlan.addMeal(new HighProteinMeal("Chicken Breast with Quinoa"));
    highProteinPlan.addMeal(new HighProteinMeal("Protein Shake"));
    System.out.println("\nVegetarian Meal Plan:");

    MealPlanGenerator.generateMealPlan(vegetarianPlan.getMeals());

    System.out.println("\nVegan Meal Plan:");
    MealPlanGenerator.generateMealPlan(veganPlan.getMeals());

    System.out.println("\nKeto Meal Plan:");
    MealPlanGenerator.generateMealPlan(ketoPlan.getMeals());

    System.out.println("\nHigh-Protein Meal Plan:");
    MealPlanGenerator.generateMealPlan(highProteinPlan.getMeals());
  }
}
