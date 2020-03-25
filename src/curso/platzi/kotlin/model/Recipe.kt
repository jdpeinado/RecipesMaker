package curso.platzi.kotlin.model

class Recipe {
    private var ingredients: ArrayList<Ingredient> = ArrayList<Ingredient>()

    fun add(ingredient: Ingredient){
        this.ingredients.add(ingredient)
    }

    fun size(): Int {
        return this.ingredients.size
    }

    override fun toString(): String {
        var message: String = ""
        for (ingredient in ingredients){
            message += "${ingredient.quantity} de ${ingredient.name} "
        }

        return message
    }
}