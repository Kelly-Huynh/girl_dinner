package com.example.girldinner.data

import com.example.girldinner.model.RecipeEntry
import com.example.girldinner.R

val airfryerChipNachos = RecipeEntry(
    1,
    "Airfryer Chip Nachos",
    false,
    R.drawable.airfryer_nachos,
    25,
    2,
    listOf(
        "750g pkt frozen McCain Air Fryer Steak Cut Chips",
        "100g (1 cup) grated cheddar cheese",
        "400g can kidney beans, drained, rinsed",
        "2 tomatoes, cut into 1cm pieces",
        "1 avocado, seed removed, cut into 1cm pieces",
        "85g (1/3 cup) sour cream",
        "1 spring onion, thinly sliced",
        "1 lime, cut into wedges"
    ),
    listOf(
        "Place the McCain Air Fryer Steak Cut Chips in the basket of an air fryer and cook at 200°C for 22 minutes, shaking the basket halfway through, or until the chips are lightly golden.",
        "Sprinkle the chips with cheese and cook for a further 3 minutes or until the cheese has melted.",
        "Meanwhile, combine the beans, tomato and avocado in a bowl. Season.",
        "Scatter the cheesy chips with the bean mixture. Season. Serve the nachos topped with sour cream and shallot, and with the lime wedges alongside."
    )
)

val dumplingSalad = RecipeEntry(
    2,
    "Dumpling Salad",
    false,
    R.drawable.dumpling_salad,
    15,
    4,
    listOf(
        "1 tbsp vegetable oil",
        "500g frozen prawn gyoza",
        "350g Asian style salad kit",
        "4 baby cucumbers or 1 cucumber, peeled into ribbons",
        "1 bunch of radishes, thinly sliced",
        "2 spring onions, shredded"
    ),
    listOf(
        "Heat the oil in a large non-stick frying pan over high heat.",
        "Carefully arrange the gyoza in a single layer, flat-side down, in the pan.",
        "Cook for 4 minutes or until the bases are golden.",
        "Reduce heat to medium then add 60ml (1/4 cup) water. Cook, covered, for 5 minutes or until just tender.",
        "Remove lid. Increase heat to high and cook for 4-5 minutes or until the water is evaporated and gyoza bases are crispy.",
        "Meanwhile, arrange the salad (including the noodles from the kit), cucumber and radish on a large serving platter.",
        "Top the salad with the gyoza and spring onion. Drizzle over the dressing from the kit to serve. "
    )
)

val tofuEggRiceBowl = RecipeEntry(
    3,
    "Tofu Egg Rice Bowl",
    false,
    R.drawable.tofu_egg_rice_bowl,
    10,
    4,
    listOf(
        "1 1/2 cups (300g) jasmine rice",
        "4 Eggs",
        "2 x 200g Thai marinated tofu",
        "350g Asian style salad kit",
        "2 tsp sesame seeds, toasted"
    ),
    listOf(
        "Cook the rice following packet directions.",
        "Meanwhile, spray a large non-stick frying pan with olive oil spray. Place over medium heat.",
        "Crack each egg into the pan, allowing room for spreading.",
        "Cook the eggs for 4-5 mins or until the whites are set and yolks are still runny.",
        "Transfer to a plate and loosely cover with foil to keep warm.",
        "Add the tofu to the pan. Cook for 2 mins each side or until heated through.",
        "Place the dressing from the salad kit in a small bowl. ",
        "Add 1/4 cup (60ml) warm water and stir to combine.",
        "Divide rice evenly among serving bowls.",
        "Top with tofu, vegetable mix from the salad kit and eggs.",
        "Drizzle with the dressing mixture. Sprinkle with sesame seeds."
    )
)

val eggAndSpinachPide = RecipeEntry(
    4,
    "Egg and spinach pide",
    false,
    R.drawable.egg_spinach_pide,
    20,
    4,
    listOf(
        "4 turkish rolls",
        "150g tub beetroot & roasted almond dip",
        "500g frozen chopped spinach, thawed",
        "200g ricotta",
        "1 garlic clove, crushed",
        "1 1/2 cups (150g) shredded cheese",
        "4 eggs",
        "1/4 cup (60ml) Golden Citrus Salad Dressing"
    ),
    listOf(
        "Preheat oven to 200°C. Line a baking tray with baking paper. ",
        "Use a large serrated knife to trim the top (about 5mm) from each roll. Discard roll tops. ",
        "Spread the cut side of the rolls with dip. Place on the lined tray. Bake for 5 mins or until rolls are light golden.",
        "Meanwhile, place the spinach in a fine sieve over a bowl. Squeeze out excess liquid and discard. ",
        "Transfer the spinach to a clean bowl. Stir in the ricotta, garlic and 1 cup (100g) cheese. Season.",
        "Spoon the spinach mixture over dip on rolls, making an indent in the centre.",
        "Carefully crack 1 egg into each indent. ",
        "Sprinkle with the remaining pizza cheese.",
        "Bake for 10-15 mins or until the egg whites are just set.",
        "Drizzle with a little dressing. Season. Serve with remaining dressing."
    )
)

val avocadoHummusToast = RecipeEntry(
    5,
    "Avocado and hummus toast",
    false,
    R.drawable.avocado_hummus_toast,
    5,
    1,
    listOf(
        "2 (38g each) slices wholegrain sourdough bread, toasted",
        "1½ tbsp hummus",
        "¼ avocado, sliced",
        "Mixed salad leaves, to serve",
        "1 tsp hemp seeds",
        "1 lime wedge"
    ),
    listOf(
        "Spread the toast with hummus.",
        "Top with the avocado.",
        "Scatter over mixed leaves, hemp seeds.",
        "Squeeze over lime to serve."
    )
)

val burgerRecipe = RecipeEntry(
    6,
    "Burgers",
    false,
    R.drawable.beef_hamburgers,
    20,
    4,
    listOf(
        "4 Burger Patties",
        "4 Buns",
        "Lettuce",
        "Tomato slices",
        "Sliced onions",
        "Burger Sauce"
    ),
    listOf(
        "Preheat grill to 200°C.",
        "Add patties onto baking tray to grill for 8 minutes.",
        "Flip patties, add in sliced onions and grill for another 8 minutes.",
        "Meanwhile, toast the cut side of buns lightly.",
        "Spread base of buns with burger sauce.",
        "Layer on lettuce, tomato, hamburger patty, grilled onions, add more sauce and top with lid of bun."
    )
)

val allRecipes = listOf(
    airfryerChipNachos,
    dumplingSalad,
    tofuEggRiceBowl,
    eggAndSpinachPide,
    avocadoHummusToast,
    burgerRecipe
)
