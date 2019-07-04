/*
overloading operators and complex numbers.
Override toString
*/

class ComplexNumber( val real: Float, val imaginary: Float) {

    operator fun plus(other: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real + other.real, imaginary + other.imaginary)
    }

    operator fun minus(other: ComplexNumber) : ComplexNumber {
        return ComplexNumber(real - other.real, imaginary - other.imaginary)
    }

    operator fun times(other: ComplexNumber) : ComplexNumber {
//   (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
//   (2 + 2i) * (3 - 5i)
// = (2 * 3 - 2 * (-5)) + (2 * 3 + 2 * (-5))i
// = (6 - (-10)) + (6 + (-10))i
// = (6 + 10) + (6 - 10 )i
// = 16 - 4i
        //                         (ac           -           bd)
        val realResult = real * other.real - imaginary * other.imaginary
        //                                   (bc           +      ad)
        val imaginaryResult = imaginary * other.real + real * other.imaginary

        return ComplexNumber(realResult, imaginaryResult)
    }

    override fun toString(): String {

        var sign = "+"

        if (imaginary < 0){
            sign = "-"
        }
        return "$real $sign ${Math.abs(imaginary)}i"
    }
}

fun main(){
    val first = ComplexNumber (2f, 2f)
    val second = ComplexNumber(3f, -5f)

    println("first = $first")
    println("second = $second")

    val sum = first + second


    println("sum = $sum")
    println("first-second = ${first - second}")
    println("first*second = ${first * second}")

}