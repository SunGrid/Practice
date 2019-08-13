
fun main(){

    val stuff = intArrayOf(1,2,3,4,5)
    println(sumUp(8,3,9,*stuff,2,10))

    extensionFunctions()

    infixFunction()
}

fun sumUp (vararg values: Int) : Int {
/*    var result = 0
    for (v in values)
        result += v
    return result
*/
    return values.sum()
}

fun <T> ArrayList<T>.swap(index1 : Int, index2 : Int){

    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}
fun Any?.print() {
    if (this == null) println("object is null")
    else println("object is ${this}")
}
val String?.empty : Boolean
    //get() = (this == null || this.length ==0)
    get() = this.isNullOrBlank()

fun extensionFunctions(){
    val myList = arrayListOf(1,2,3,4,5)
    myList.swap(0,4)
    println(myList)

    myList.print()

    val s : String? = ""
    s.print()
    println(s.empty)
}


// infix
infix fun Double.averageWidth(other: Double) : Double {
    return (this + other) / 2.0
}
fun infixFunction() {
    val x = 'z' downTo 'a'
    val capitals = mapOf("Paris" to "France", "London" to "UK")

    val a = 3.0
    val b = 10.0
    println ("The avg of $a and $b is ${a averageWidth b}")
}