package Challenges

class Player(_name: String, val health: Int) {
    val race = "DWARF"
    var town = "Bavaria"
    val name = _name
    lateinit var alignment: String
    private var age = 0
    init {
        println("initializing player")
        //alignment = "GOOD"
    }

    constructor(_name: String) : this(_name, 100) {
        town = "The Shire"
    }

    fun determinateFate() {
        alignment ="Good"
    }
    fun proclaimFate() {
        if(::alignment.isInitialized) println(alignment)
    }

    override fun toString(): String {
        return "player name: $name of $town \n" +
                "race is $race \n" +
                "age: $age years old \n"+
                "alignment: $alignment ."
    }
}

fun main(args: Array<String>) {
    print(Player("Madrigal"))
}