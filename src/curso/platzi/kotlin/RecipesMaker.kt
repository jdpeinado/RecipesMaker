package curso.platzi.kotlin

import curso.platzi.kotlin.model.Ingredient
import curso.platzi.kotlin.model.Recipe
import java.lang.NumberFormatException

fun main() {
    println(":: Bienvenido a Recipe Maker ::\n")

    var recipes:ArrayList<Recipe> = ArrayList<Recipe>()

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

fun makeRecipe():Recipe{

    var recipe:Recipe = Recipe()

    do{
        writeCategory()
        val option = readOption()

        when(option){
            1 -> {println("Ingrediente Agua añadido"); recipe.add(Ingredient(readQuantity(), "Agua"))}
            2 -> {
                println("Categoria Leche seleccionada")
                do{
                    writeCategoryLeche()
                    val option2 = readOption()
                    when(option2){
                        1 -> {println("Ingrediente Leche añadido"); recipe.add(Ingredient(readQuantity(), "Leche"))}
                        2 -> {println("Ingrediente Queso añadido"); recipe.add(Ingredient(readQuantity(), "Queso"))}
                        3 -> {println("Ingrediente Yogurt añadido"); recipe.add(Ingredient(readQuantity(), "Yogurt"))}
                    }
                } while (option2!=4)
            }
            3 -> {
                println("Categoria Carne seleccionada")
                do{
                    writeCategoryCarne()
                    val option2 = readOption()
                    when(option2){
                        1 -> {println("Ingrediente Res añadido"); recipe.add(Ingredient(readQuantity(), "Res"))}
                        2 -> {println("Ingrediente Cerdo añadido"); recipe.add(Ingredient(readQuantity(), "Cerdo"))}
                        3 -> {println("Ingrediente Pollo añadido"); recipe.add(Ingredient(readQuantity(), "Pollo"))}
                    }
                } while (option2!=4)
            }
            4 -> {
                println("Categoria Verduras seleccionada")
                do{
                    writeCategoryVerduras()
                    val option2 = readOption()
                    when(option2){
                        1 -> {println("Ingrediente Pimiento añadido"); recipe.add(Ingredient(readQuantity(), "Pimiento"))}
                        2 -> {println("Ingrediente Calabacita añadido"); recipe.add(Ingredient(readQuantity(), "Calabacita"))}
                        3 -> {println("Ingrediente Zanahoria añadido"); recipe.add(Ingredient(readQuantity(), "Zanahoria"))}
                        4 -> {println("Ingrediente Brócoli añadido"); recipe.add(Ingredient(readQuantity(), "Brócoli"))}
                        5 -> {println("Ingrediente Espinaca añadido"); recipe.add(Ingredient(readQuantity(), "Espinaca"))}
                    }
                } while (option2!=6)
            }
            5 -> {
                println("Categoria Fruta seleccionada")
                do{
                    writeCategoryFrutas()
                    val option2 = readOption()
                    when(option2){
                        1 -> {println("Ingrediente Fresa añadido"); recipe.add(Ingredient(readQuantity(), "Fresa"))}
                        2 -> {println("Ingrediente Plátano añadido"); recipe.add(Ingredient(readQuantity(), "Plátano"))}
                        3 -> {println("Ingrediente Uvas añadido"); recipe.add(Ingredient(readQuantity(), "Uvas"))}
                        4 -> {println("Ingrediente Manzana añadido"); recipe.add(Ingredient(readQuantity(), "Manzana"))}
                        5 -> {println("Ingrediente Naranja añadido"); recipe.add(Ingredient(readQuantity(), "Naranja"))}
                        6 -> {println("Ingrediente Pera añadido"); recipe.add(Ingredient(readQuantity(), "Pera"))}
                        7 -> {println("Ingrediente Cereza añadido"); recipe.add(Ingredient(readQuantity(), "Cereza"))}
                    }
                } while (option2!=8)
            }
            6 -> {
                println("Categoria Cereal seleccionada")
                do{
                    writeCategoryCereal()
                    val option2 = readOption()
                    when(option2){
                        1 -> {println("Ingrediente Avena añadido"); recipe.add(Ingredient(readQuantity(), "Avena"))}
                        2 -> {println("Ingrediente Trigo añadido"); recipe.add(Ingredient(readQuantity(), "Trigo"))}
                        3 -> {println("Ingrediente Arroz añadido"); recipe.add(Ingredient(readQuantity(), "Arroz"))}
                        4 -> {println("Ingrediente Maíz añadido"); recipe.add(Ingredient(readQuantity(), "Maíz"))}
                    }
                } while (option2!=5)
            }
            7 -> {println("Ingrediente Agua añadido"); recipe.add(Ingredient(readQuantity(), "Agua"))}
            8 -> {println("Ingrediente Agua añadido"); recipe.add(Ingredient(readQuantity(), "Agua"))}
        }

        if (recipe.size()==0){
            println("Se debe añadir al menos un ingrediente")
        }

    } while (option!=9 || recipe.size()==0)

    return recipe
}

fun seeRecipes(recipes: ArrayList<Recipe>?){
    for ((index,recipe) in recipes!!.withIndex()){
        print("Receta $index, ingredientes: $recipe")
        /*for (ingredient in recipe){
            print("$ingredient ")
        }*/
        println()
    }
}

fun writeCategoryCereal(){
    val ingredients = """
        1. Avena
        2. Trigo
        3. Arroz
        4. Maíz
        5. Finalizar Categoria
    """.trimIndent()

    println(ingredients)
}

fun writeCategoryFrutas(){
    val ingredients = """
        1. Fresa
        2. Plátano
        3. Uvas
        4. Manzana
        5. Naranja
        6. Pera
        7. Cereza
        8. Finalizar Categoria
    """.trimIndent()

    println(ingredients)
}

fun writeCategoryVerduras(){
    val ingredients = """
        1. Pimiento
        2. Calabacita
        3. Zanahoria
        4. Brócoli
        5. Espinaca
        6. Finalizar Categoria
    """.trimIndent()

    println(ingredients)
}

fun writeCategoryCarne(){
    val ingredients = """
        1. Res
        2. Cerdo
        3. Pollo
        4. Finalizar Categoria
    """.trimIndent()

    println(ingredients)
}

fun writeCategoryLeche(){
    val ingredients = """
        1. Leche
        2. Queso
        3. Yogurt
        4. Finalizar Categoria
    """.trimIndent()

    println(ingredients)
}

fun writeCategory(){
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

fun readQuantity(): Int {

    print("Escriba la cantidad a añadir (por defecto 1): ")
    var option = readOption()
    if (option == 0 || option == null)
        option = 1

    return option
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