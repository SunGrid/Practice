
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

fun main(args: Array<String>) {

    val myString = "Kotlin"

    println("toLower= ${myString.toLowerCase()}")
}
