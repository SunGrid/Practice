class Person(private var firstName: String, private var lastName: String, age: Int) {

    var age: Int = 0
        set(value) {
            var newAge = value

            if (value < 0) newAge = 0
            if (value > 100) newAge = 100

            field = newAge
        }

    init {
        this.age = age
    }

    private val fullName: String
        get() = firstName + " " + lastName

    fun printInfo() {
        println("First name = $firstName Last name = $lastName Full Name = $fullName age = $age")
    }
}

fun main(args: Array<String>) {

    val me = Person("Michael", "Lonnecker", 48)
    me.printInfo()

    val minch = Person("Minch", "Yoda", 900)
    minch.printInfo()

    val benjamin = Person("Benjamin", "Button", -20)
    benjamin.printInfo()
}
