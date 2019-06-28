import java.util.*


class Person(private val name: String, private var age: Int){
    init{
        println("Person $name was created")
    }
    
    constructor(name: String): this(name, Random().nextInt()){
        println("Secondary constructor involved")
    }
    
    fun describeMe() = println("My name is $name and I am $age years old")
}

fun evenOdd(str1: String = "str1", str2: String = "str-2") : Boolean{
	 if ( (str1.length % 2  == 0) || (str2.length % 2 == 0) ){
         return true       
     } else {
         return false
     }    
}

/*
fun String.evenOdd() : Boolean {
    if (this.isNullOrEmpty()) return false
    if (this.length % 2 == 0) {
        return true
    }else {
        return false
    }
}
*/
fun String.evenOdd() = !this.isNullOrEmpty() && this.length % 2 == 0

object stringUtils{ // list static method
	fun sumOfChars(str1: String? = "", str2: String? = "") : Int {
   		
        if ( str1.isNullOrEmpty() && str2.isNullOrEmpty() ) {
            return 0
        }else if (str1.isNullOrEmpty() ){
               return str2!!.length            
        }else if (str2.isNullOrEmpty() ){
            return str1!!.length
        }
        
	    return str1!!.length + str2!!.length
	}
}


fun main() {
	 Person("Michael").describeMe()  
    
    println("Strings and such")   
    println( evenOdd("value"))

	var myString = "Kotlin is Cool"
    
    println("String is true if even amount of chars: ${myString.evenOdd()}")    
    
    println("${stringUtils.sumOfChars("hello","This is cool")}")
    println("${stringUtils.sumOfChars()}")
    println("${stringUtils.sumOfChars("r","")}")
    println("${stringUtils.sumOfChars(null, null)}")
        
    
}
