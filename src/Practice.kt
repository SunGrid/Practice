
object StringUtils {
/*
    fun startsWithUpperCase(value: String?): Boolean {
        if (value.isNullOrBlank()) {
            return false
        }
        return value!![0].isUpperCase()
        return !(value.isNullOrBlank()) && value!![0].isUpperCase()
    }
*/
    fun startsWithUpperCase(value: String?) : Boolean = !(value.isNullOrBlank()) && value!![0].isUpperCase()
}

// extension method. used in place of decorator pattern.
fun String?.startsWithUpperCase() : Boolean = !(this.isNullOrBlank()) && this!![0].isUpperCase()

//fun Int.multiplyBy(multiplier: Int) = this * multiplier
// if single value parameter then using the keyword infix is nice
infix fun Int.multiplyBy(multiplier: Int) = this * multiplier

fun main(args: Array<String>) {

    val myString = "Kotlin"

    println("toLower= ${myString.toLowerCase()}")

    println("startsWithUpper = ${StringUtils.startsWithUpperCase(myString)}")
    println("startsWithUpper = ${StringUtils.startsWithUpperCase(null)}")
    println("startsWithUpper = ${StringUtils.startsWithUpperCase("")}")
    println("startsWithUpper = ${StringUtils.startsWithUpperCase("kotlin")}")

    println("startsWithUpper extension method = ${myString.startsWithUpperCase()}")

    println("multiplyBy = ${5.multiplyBy(3)}")
    println("multiplyBy = ${5 multiplyBy 5}") //with infix keyword used.
}
