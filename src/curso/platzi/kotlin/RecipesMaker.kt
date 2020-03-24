package curso.platzi.kotlin

import java.lang.NumberFormatException

fun main() {
    println(":: Bienvenido a Recipe Maker ::\n")

    var recipes:ArrayList<ArrayList<String>> = ArrayList<ArrayList<String>>()

    do {
        writeMenu()
        val option = readOption()

        when(option){
            1 -> recipes.add(makeRecipe())
            2 -> {
                if(recipes.size!=0)
                    seeRecipes(recipes)
                else
                    println("Aun no existen recetas")
                }
        }

    } while (option!=3)
}

fun makeRecipe():ArrayList<String>{

    var recipe:ArrayList<String> = ArrayList<String>()

    do{
        writeIngredients()
        val option = readOption()

        when(option){
            1 -> {println("Ingrediente Agua añadido"); recipe.add("Agua")}
            2 -> {println("Ingrediente Leche añadido"); recipe.add("Leche")}
            3 -> {println("Ingrediente Carne añadido"); recipe.add("Carne")}
            4 -> {println("Ingrediente Verduras añadido"); recipe.add("Verduras")}
            5 -> {println("Ingrediente Frutas añadido"); recipe.add("Frutas")}
            6 -> {println("Ingrediente Cereal añadido"); recipe.add("Cereal")}
            7 -> {println("Ingrediente Huevos añadido"); recipe.add("Huevos")}
            8 -> {println("Ingrediente Aceite añadido"); recipe.add("Aceite")}
        }

        if (recipe.size==0){
            println("Se debe añadir al menos un ingrediente")
        }

    } while (option!=9 || recipe.size==0)

    return recipe
}

fun seeRecipes(recipes: ArrayList<ArrayList<String>>?){
    for ((index,recipe) in recipes!!.withIndex()){
        print("Receta $index, ingredientes: ")
        for (ingredient in recipe){
            print("$ingredient ")
        }
        println()
    }
}

fun writeIngredients(){
    val ingredients = """
        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceite
        9. Finalizar Receta
    """.trimIndent()

    println(ingredients)
}

fun writeMenu(){
    val menu = """
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

    println(menu)
}

fun readOption(): Int? {
    var option:Int?
    try {
        option = readLine()?.toInt() ?:0
    } catch (nfe: NumberFormatException){
        option = 0
    }

    return option
}