package model.base;
import model.factory.ProductFactory;
import model.product.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

public class MenuData {
	public static Map<String, List<Product>> initializeMenu() {
	    Map<String, List<Product>> menu = new HashMap<>();

	    // BEVERAGES (25)
	    add(menu, ProductFactory
	            .buildBeverage("Dreams", 45.0)
	            .withSize(Beverage.Size.MEDIUM)
	            .isCarbonated(false)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/dreamscape.png")))
	            .build());

	    add(menu, ProductFactory
	            .buildBeverage("El Dorado", 55.0)
	            .withSize(Beverage.Size.MEDIUM)
	            .isCarbonated(true)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/el-dorado.png")))
	            .build());

	    add(menu, ProductFactory
	            .buildBeverage("Energy Drink", 60.0)
	            .withSize(Beverage.Size.MEDIUM)
	            .isCarbonated(true)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/energy_drink.png")))
	            .build());

	    add(menu, ProductFactory
	            .buildBeverage("Ice Palace", 40.0)
	            .withSize(Beverage.Size.SMALL)
	            .isCarbonated(false)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/ice_palace.png")))
	            .build());
	    add(menu, ProductFactory.buildBeverage("Coca-Cola", 45.0).withSize(Beverage.Size.MEDIUM).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Pepsi", 45.0).withSize(Beverage.Size.MEDIUM).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Sprite", 45.0).withSize(Beverage.Size.MEDIUM).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Royal Tru-Orange", 45.0).withSize(Beverage.Size.MEDIUM).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Mountain Dew", 45.0).withSize(Beverage.Size.MEDIUM).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Mineral Water", 20.0).withSize(Beverage.Size.SMALL).build());
	    add(menu, ProductFactory.buildBeverage("Iced Americano", 85.0).withSize(Beverage.Size.LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Cafe Latte", 95.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Caramel Macchiato", 115.0).withSize(Beverage.Size.LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Orange Juice", 65.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Mango Shake", 110.0).withSize(Beverage.Size.EXTRA_LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Hot Green Tea", 55.0).withSize(Beverage.Size.SMALL).build());
	    add(menu, ProductFactory.buildBeverage("Lemon Iced Tea", 50.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Strawberry Juice", 70.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Avocado Shake", 120.0).withSize(Beverage.Size.EXTRA_LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Pineapple Juice", 65.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Hot Chocolate", 75.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Cappuccino", 95.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Mocha Frappe", 130.0).withSize(Beverage.Size.LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Sparkling Water", 35.0).withSize(Beverage.Size.SMALL).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Watermelon Juice", 75.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Calamansi Juice", 45.0).withSize(Beverage.Size.MEDIUM).build());
	    add(menu, ProductFactory.buildBeverage("Taro Milk Tea", 105.0).withSize(Beverage.Size.LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Brown Sugar Milk Tea", 110.0).withSize(Beverage.Size.LARGE).build());
	    add(menu, ProductFactory.buildBeverage("Energy Drink", 80.0).withSize(Beverage.Size.SMALL).isCarbonated(true).build());
	    add(menu, ProductFactory.buildBeverage("Iced Matcha", 95.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Thai Milk Tea", 105.0).withSize(Beverage.Size.LARGE).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBeverage("Black Coffee", 70.0).withSize(Beverage.Size.SMALL).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBeverage("Espresso Shot", 60.0).withSize(Beverage.Size.SMALL).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Vanilla Latte", 110.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBeverage("Hazelnut Coffee", 105.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBeverage("Lychee Juice", 75.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Guava Juice", 70.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBeverage("Melon Shake", 95.0).withSize(Beverage.Size.LARGE).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBeverage("Iced Mocha", 120.0).withSize(Beverage.Size.LARGE).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBeverage("Cold Brew", 115.0).withSize(Beverage.Size.LARGE).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Apple Juice", 65.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBeverage("Peach Tea", 80.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Kiwi Smoothie", 120.0).withSize(Beverage.Size.LARGE).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBeverage("Blueberry Shake", 125.0).withSize(Beverage.Size.LARGE).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBeverage("Choco Milk", 85.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBeverage("Iced Vanilla Coffee", 115.0).withSize(Beverage.Size.LARGE).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBeverage("Herbal Tea", 60.0).withSize(Beverage.Size.SMALL).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBeverage("Soda Float", 90.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBeverage("Strawberry Milk", 95.0).withSize(Beverage.Size.MEDIUM).withDiscount(0.15).build());
	    
	    // SNACKS (25)
	    add(menu, ProductFactory
	            .buildSnack("Potato Chips", 35.0)
	            .ofType(Snack.SnackType.CHIPS)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/trick_snack.png")))
	            .build());
	    add(menu, ProductFactory
	            .buildSnack("Balls", 25.0)
	            .ofType(Snack.SnackType.CHIPS)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/balls.png")))
	            .build());

	    add(menu, ProductFactory
	            .buildSnack("Huaban Skewers", 50.0)
	            .ofType(Snack.SnackType.CHIPS)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/huaban_skewers.png")))
	            .build());

	    add(menu, ProductFactory
	            .buildSnack("Bounce Bounce", 40.0)
	            .ofType(Snack.SnackType.CHOCOLATE)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/bounce_bounce.png")))
	            .build());
	    add(menu, ProductFactory.buildSnack("Potato Chips", 35.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Corn Chips", 30.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Cheese Curls", 28.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Roasted Peanuts", 25.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("Cashew Nuts", 60.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("Dark Chocolate", 55.0).ofType(Snack.SnackType.CHOCOLATE).build());
	    add(menu, ProductFactory.buildSnack("Milk Chocolate", 50.0).ofType(Snack.SnackType.CHOCOLATE).build());
	    add(menu, ProductFactory.buildSnack("Butter Biscuits", 40.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Oatmeal Cookies", 45.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Pretzels", 38.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Popcorn", 32.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Chicharon", 45.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Dried Mango", 55.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Trail Mix", 65.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("Almonds", 70.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("Pistachio", 85.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("White Chocolate", 55.0).ofType(Snack.SnackType.CHOCOLATE).build());
	    add(menu, ProductFactory.buildSnack("Choco Bars", 30.0).ofType(Snack.SnackType.CHOCOLATE).build());
	    add(menu, ProductFactory.buildSnack("Chocolate Truffles", 90.0).ofType(Snack.SnackType.CHOCOLATE).build());
	    add(menu, ProductFactory.buildSnack("Graham Crackers", 35.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Rice Crackers", 30.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Oreo Cookies", 42.0).ofType(Snack.SnackType.BISCUITS).build());
	    add(menu, ProductFactory.buildSnack("Pork Rinds", 40.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Seaweed Crisps", 48.0).ofType(Snack.SnackType.CHIPS).build());
	    add(menu, ProductFactory.buildSnack("Macadamia Nuts", 95.0).ofType(Snack.SnackType.NUTS).build());
	    add(menu, ProductFactory.buildSnack("BBQ Chips", 40.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Spicy Corn Chips", 35.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildSnack("Honey Butter Chips", 45.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildSnack("Wasabi Peas", 50.0).ofType(Snack.SnackType.NUTS).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Salted Almonds", 65.0).ofType(Snack.SnackType.NUTS).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildSnack("Chocolate Wafer", 30.0).ofType(Snack.SnackType.CHOCOLATE).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Choco Cookies", 35.0).ofType(Snack.SnackType.BISCUITS).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildSnack("Mini Pretzels", 32.0).ofType(Snack.SnackType.BISCUITS).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Caramel Popcorn", 40.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildSnack("Sweet Corn", 28.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Mixed Nuts", 75.0).ofType(Snack.SnackType.NUTS).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildSnack("Chocolate Bites", 45.0).ofType(Snack.SnackType.CHOCOLATE).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Vanilla Biscuits", 38.0).ofType(Snack.SnackType.BISCUITS).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildSnack("Rice Puffs", 30.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Peanut Brittle", 55.0).ofType(Snack.SnackType.NUTS).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildSnack("Choco Stick", 25.0).ofType(Snack.SnackType.CHOCOLATE).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildSnack("Butter Crackers", 33.0).ofType(Snack.SnackType.BISCUITS).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildSnack("Cheese Balls", 35.0).ofType(Snack.SnackType.CHIPS).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildSnack("Trail Nuts Mix", 80.0).ofType(Snack.SnackType.NUTS).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildSnack("Dark Choco Bar", 60.0).ofType(Snack.SnackType.CHOCOLATE).withDiscount(0.10).build());
	    
	    // MEALS (25)
	    add(menu, ProductFactory.buildMeal("Chicken Rice", 120.0)
	            .ofType(Meal.MealType.RICE_MEAL)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/deep_fried_rock_crab.png")))
	            .build());

	    add(menu, ProductFactory.buildMeal("Comfort Food", 120.0)
	            .ofType(Meal.MealType.RICE_MEAL)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/comfort_food.png")))
	            .build());

	    add(menu, ProductFactory.buildMeal("Gold Standard", 120.0)
	            .ofType(Meal.MealType.RICE_MEAL)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/gold_standard.png")))
	            .build());

	    add(menu, ProductFactory.buildMeal("Snapper Jam", 120.0)
	            .ofType(Meal.MealType.RICE_MEAL)
	            .withImage(new ImageIcon(MenuData.class.getResource("/images/snapper_jam.png")))
	            .build());
	    add(menu, ProductFactory.buildMeal("Chicken Rice", 120.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(.1).build());
	    add(menu, ProductFactory.buildMeal("Beef Pares Rice", 140.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Pork Sinigang Rice", 135.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Adobo Rice Bowl", 125.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Spaghetti Bolognese", 115.0).ofType(Meal.MealType.PASTA).build());
	    add(menu, ProductFactory.buildMeal("Creamy Carbonara", 125.0).ofType(Meal.MealType.PASTA).build());
	    add(menu, ProductFactory.buildMeal("Classic Burger", 95.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Double Cheeseburger", 130.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Chicken Sandwich", 85.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Family Combo A", 450.0).ofType(Meal.MealType.COMBO).isCombo(true).build());
	    add(menu, ProductFactory.buildMeal("Breakfast Combo", 180.0).ofType(Meal.MealType.COMBO).isCombo(true).build());
	    add(menu, ProductFactory.buildMeal("Lechon Kawali Rice", 145.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Bangus Sisig Rice", 130.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Kare-Kare Rice", 155.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Tinola Rice", 125.0).ofType(Meal.MealType.RICE_MEAL).build());
	    add(menu, ProductFactory.buildMeal("Pesto Pasta", 120.0).ofType(Meal.MealType.PASTA).build());
	    add(menu, ProductFactory.buildMeal("Lasagna", 145.0).ofType(Meal.MealType.PASTA).build());
	    add(menu, ProductFactory.buildMeal("Mac and Cheese", 110.0).ofType(Meal.MealType.PASTA).build());
	    add(menu, ProductFactory.buildMeal("Chicken Nuggets", 90.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Fish Fillet Burger", 95.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Hotdog Sandwich", 75.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("Value Combo B", 220.0).ofType(Meal.MealType.COMBO).isCombo(true).build());
	    add(menu, ProductFactory.buildMeal("Shawarma Plate", 160.0).ofType(Meal.MealType.FAST_FOOD).build());
	    add(menu, ProductFactory.buildMeal("BBQ Pork Combo", 195.0).ofType(Meal.MealType.COMBO).isCombo(true).build());
	    add(menu, ProductFactory.buildMeal("Student Meal Deal", 99.0).ofType(Meal.MealType.COMBO).isCombo(true).build());
	    add(menu, ProductFactory.buildMeal("Grilled Chicken Rice", 130.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Beef Tapa Rice", 140.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Chicken Curry Rice", 135.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildMeal("BBQ Chicken Rice", 125.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Seafood Pasta", 150.0).ofType(Meal.MealType.PASTA).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Shrimp Alfredo", 145.0).ofType(Meal.MealType.PASTA).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Bacon Burger", 120.0).ofType(Meal.MealType.FAST_FOOD).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildMeal("Chicken Wrap", 95.0).ofType(Meal.MealType.FAST_FOOD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Combo Feast", 350.0).ofType(Meal.MealType.COMBO).isCombo(true).withDiscount(0.25).build());
	    add(menu, ProductFactory.buildMeal("Mini Combo", 150.0).ofType(Meal.MealType.COMBO).isCombo(true).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Fried Chicken Meal", 110.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Pork BBQ Meal", 120.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Tuna Pasta", 115.0).ofType(Meal.MealType.PASTA).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Veggie Pasta", 105.0).ofType(Meal.MealType.PASTA).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildMeal("Cheese Burger Deluxe", 135.0).ofType(Meal.MealType.FAST_FOOD).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Hotdog Meal", 85.0).ofType(Meal.MealType.FAST_FOOD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildMeal("Mega Combo", 500.0).ofType(Meal.MealType.COMBO).isCombo(true).withDiscount(0.30).build());
	    add(menu, ProductFactory.buildMeal("Rice + Chicken Set", 140.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildMeal("Spicy Chicken Meal", 130.0).ofType(Meal.MealType.RICE_MEAL).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildMeal("Budget Meal", 99.0).ofType(Meal.MealType.COMBO).isCombo(true).withDiscount(0.10).build());
	    
	    
	    // DESSERTS (25)
	    add(menu, ProductFactory.buildDessert("Chocolate Cake", 85.0).ofType(Dessert.DessertType.CAKE).build());
	    add(menu, ProductFactory.buildDessert("Red Velvet Slice", 95.0).ofType(Dessert.DessertType.CAKE).build());
	    add(menu, ProductFactory.buildDessert("Vanilla Ice Cream", 40.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Strawberry Sundae", 65.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Apple Pie", 75.0).ofType(Dessert.DessertType.PASTRY).build());
	    add(menu, ProductFactory.buildDessert("Glazed Donut", 35.0).ofType(Dessert.DessertType.PASTRY).build());
	    add(menu, ProductFactory.buildDessert("Fruit Gummy", 25.0).ofType(Dessert.DessertType.CANDY).build());
	    add(menu, ProductFactory.buildDessert("Caramel Pudding", 50.0).build());
	    add(menu, ProductFactory.buildDessert("Halo-Halo", 120.0).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Leche Flan", 60.0).ofType(Dessert.DessertType.CAKE).build());
	    add(menu, ProductFactory.buildDessert("Cheesecake Slice", 110.0).ofType(Dessert.DessertType.CAKE).build());
	    add(menu, ProductFactory.buildDessert("Ube Cake", 95.0).ofType(Dessert.DessertType.CAKE).build());
	    add(menu, ProductFactory.buildDessert("Mango Float", 85.0).ofType(Dessert.DessertType.PASTRY).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Buko Pandan", 70.0).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Chocolate Ice Cream", 45.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Ube Ice Cream", 50.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Mango Sorbet", 55.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Banana Split", 90.0).ofType(Dessert.DessertType.ICE_CREAM).isCold(true).build());
	    add(menu, ProductFactory.buildDessert("Churros", 65.0).ofType(Dessert.DessertType.PASTRY).build());
	    add(menu, ProductFactory.buildDessert("Crepe", 70.0).ofType(Dessert.DessertType.PASTRY).build());
	    add(menu, ProductFactory.buildDessert("Lollipop", 15.0).ofType(Dessert.DessertType.CANDY).build());
	    add(menu, ProductFactory.buildDessert("Gummy Bears", 20.0).ofType(Dessert.DessertType.CANDY).build());
	    add(menu, ProductFactory.buildDessert("Cotton Candy", 30.0).ofType(Dessert.DessertType.CANDY).build());
	    add(menu, ProductFactory.buildDessert("Marshmallows", 25.0).ofType(Dessert.DessertType.CANDY).build());
	    add(menu, ProductFactory.buildDessert("Turon", 20.0).ofType(Dessert.DessertType.PASTRY).build());
	    add(menu, ProductFactory.buildDessert("Choco Lava Slice", 95.0).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Mini Cheesecake", 85.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Matcha Ice Cream", 60.0).isCold(true).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildDessert("Caramel Sundae", 70.0).isCold(true).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Peach Pie", 80.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Donut Holes", 40.0).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildDessert("Gummy Worms", 30.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Milk Pudding", 55.0).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Ice Scramble", 50.0).isCold(true).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildDessert("Custard Cake", 90.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Chocolate Roll", 85.0).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Fruit Salad", 65.0).isCold(true).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildDessert("Vanilla Cupcake", 45.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Strawberry Cake", 95.0).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Mango Ice Cream", 55.0).isCold(true).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Banana Cake", 75.0).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildDessert("Choco Sundae", 70.0).isCold(true).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildDessert("Caramel Cake", 90.0).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildDessert("Sweet Jelly", 35.0).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildDessert("Candy Mix", 40.0).withDiscount(0.10).build());
	    
	    // BAKERY (25)
	    add(menu, ProductFactory.buildBakery("Pandesal 10pcs", 50.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Whole Wheat Loaf", 85.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Ensaymada Special", 45.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Cheese Bread", 15.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Chocolate Croissant", 75.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Blueberry Muffin", 65.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Ube Cake Roll", 220.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Fudge Brownies", 35.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Spanish Bread", 12.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Baguette", 90.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Sourdough Loaf", 120.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Cinnamon Roll", 55.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Banana Bread", 75.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Raisin Bread", 70.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Garlic Bread", 40.0).ofType(Bakery.BakeryType.BREAD).build());
	    add(menu, ProductFactory.buildBakery("Egg Pie", 95.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Polvoron", 20.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Empanada", 30.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Bibingka", 55.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Puto", 10.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Kutsinta", 10.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Kakanin Set", 65.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Lemon Tart", 80.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Choco Lava Cake", 110.0).ofType(Bakery.BakeryType.CAKE).build());
	    add(menu, ProductFactory.buildBakery("Cheese Muffin", 55.0).ofType(Bakery.BakeryType.PASTRY).build());
	    add(menu, ProductFactory.buildBakery("Mini Pandesal", 30.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Butter Loaf", 90.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBakery("Chocolate Bread", 50.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Mini Croissant", 60.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBakery("Strawberry Muffin", 70.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBakery("Choco Cake Slice", 95.0).ofType(Bakery.BakeryType.CAKE).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Banana Muffin", 65.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Garlic Bun", 45.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBakery("Sweet Roll", 40.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Cream Puff", 55.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBakery("Choco Donut", 35.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Mini Cake", 120.0).ofType(Bakery.BakeryType.CAKE).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBakery("Milk Bread", 70.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Sugar Donut", 30.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.05).build());
	    add(menu, ProductFactory.buildBakery("Cheese Roll", 50.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Chocolate Muffin", 75.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBakery("Fruit Cake Slice", 100.0).ofType(Bakery.BakeryType.CAKE).withDiscount(0.20).build());
	    add(menu, ProductFactory.buildBakery("Egg Tart", 60.0).ofType(Bakery.BakeryType.PASTRY).withDiscount(0.10).build());
	    add(menu, ProductFactory.buildBakery("Butter Cake", 90.0).ofType(Bakery.BakeryType.CAKE).withDiscount(0.15).build());
	    add(menu, ProductFactory.buildBakery("Mini Baguette", 70.0).ofType(Bakery.BakeryType.BREAD).withDiscount(0.10).build());

	    return menu;
	}

    private static void add(Map<String, List<Product>> menu, Product product) {
        menu.computeIfAbsent(product.getCategory().toUpperCase(), _ -> new ArrayList<>()).add(product);
    }
}