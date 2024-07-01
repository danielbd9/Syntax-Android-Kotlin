package com.pt.syntax

import com.pt.syntax.examples.CalculatorClass
import com.pt.syntax.examples.MyAbstractClass
import com.pt.syntax.examples.RectangleClass
import java.lang.Integer.sum
import kotlin.reflect.KFunction3

var x: Int = 5
var y: Int = 5

val p: String by lazy {
    "Hello"
}

fun main() {
    // Increment x and print the sum of x and y
    x += 1
    println(sum(x, y))

    // Print the lazily initialized string
    println(p)

    // Print a formatted string
    val s1 = 1
    val s2 = "a is $s1"
    println(s2)

    // Create and manipulate a map of items
    val items = listOf("apple", "banana", "kiwifruit")
    val itemsMap = mutableMapOf("apple" to 1, "banana" to 2, "kiwifruit" to 3)

    // Print the value associated with the key "apple"
    println(itemsMap["apple"])

    // Add a new item to the map
    itemsMap["banana"] = 3

    // Iterate over the map and print its contents
    for ((k, v) in itemsMap) {
        println("$k -> $v")
    }

    // Filter and print positive integers from a list
    val integers = listOf(1, 2, 3, 4, 5)
    val positives = integers.filter { x -> x > 0 }
    positives.forEach { println(it) }

    // Check if "apple" is in the list and print a message
    if ("apple" in items) {
        println("apple is fine")
    }

    // Call various functions to demonstrate functionality
    listFruits()
    listFruitsWithIndices(items)
    listItemsWithWhileLoop(items)
    demonstrateWhenStatement(1)
    println(demonstrateWhenWithAnyObject(1))
    demonstrateWhenInRange(1, 2)
    checkOutOfRange(items)
    iterateOverRange()
    iterateWithProgression()
    demonstrateLambda(items)

    // Convert camel case to space separated string and print it
    val camel = "appleBanana".convertCamelCaseToSpace()
    println(camel)

    // Print a resource name
    println(Resource.NAME)

    // Demonstrate usage of `with`
    withExample()

    // Create an object of an abstract class and call its methods
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            println("Doing something in the abstract class implementation.")
        }

        override fun sleep() {
            println("Sleeping in the abstract class implementation.")
        }
    }
    myObject.doSomething()
    myObject.sleep()

    // Create and manipulate a rectangle object
    val myRectangle = RectangleClass().apply {
        length = 4
        breadth = 5
        color = 0xFAFAFA
    }
    println("Length: ${myRectangle.length}")
    println("Breadth: ${myRectangle.breadth}")
    println("Color: ${myRectangle.color.toString(16)}")
    println("Area: ${myRectangle.area()}")
    println("Perimeter: ${myRectangle.perimeter()}")

    // Measure the time taken to execute a block of code
    measureExecutionTime {
        for (i in 1..10) {
            println(i)
        }
    }

    // Swap values of a and b using also
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a: $a, b: $b")

    // Demonstrate run function
    demonstrateRun()

    // Demonstrate apply function
    demonstrateApply()

    // Demonstrate let function
    demonstrateLetFunction("Sample String")

    // Demonstrate nested class
    val nested = NestedClass()
    nested.nestedFunction()

    // Demonstrate interface implementation
    val interfaceImpl = InterfaceImplementation()
    interfaceImpl.interfaceMethod()

    // Demonstrate inheritance
    val child = ChildClass()
    child.parentMethod()

    // Call a high-order function example
    val sumResult = highOrderFunction(CalculatorClass::sum, 3, 5)
    println("Sum using highOrderFunction: $sumResult")

    val subResult = highOrderFunction(CalculatorClass::subtract, 3, 5)
    println("Sum using highOrderFunction: $subResult")

    // Check string length using the is-check example
    val lengthResult = checkStringLength("Hello")
    println("String length: $lengthResult")

    //Check max value using the maxOf function
    println(maxOf(1, 2))
}

// Higher-order function that performs an operation on two integers
fun highOrderFunction(operation: KFunction3<CalculatorClass, Int, Int, Int>, a: Int, b: Int): Int {
    return operation(CalculatorClass(), a, b)
}

// Inline function to measure execution time of a block of code
inline fun measureExecutionTime(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Elapsed time: ${end - start} ms")
}

// Demonstrate usage of `with`
fun withExample() {
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

// Demonstrate usage of `run`
fun demonstrateRun() {
    val result = "Hello".run {
        length > 5
    }
    println("Result of run: $result")
}

// Demonstrate usage of `apply`
fun demonstrateApply() {
    val rect = RectangleClass().apply {
        length = 4
        breadth = 5
        color = 0xFAFAFA
    }
    println("Rectangle - Length: ${rect.length}, Breadth: ${rect.breadth}, Color: ${rect.color.toString(16)}")
}

// Demonstrate usage of `let`
fun demonstrateLetFunction(name: String?) {
    name?.let {
        println(it)
    }
}

// Extension function to convert camel case string to space separated
fun String.convertCamelCaseToSpace(): String {
    return split("(?=[A-Z])".toRegex()).joinToString(" ") { it.lowercase() }
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

// Singleton object to demonstrate singleton pattern
object Resource {
    const val NAME = "Name"
}

// Function to list fruits
fun listFruits() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

// Function to list fruits with their indices
fun listFruitsWithIndices(items: List<String>) {
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

// Function to list items using while loop
fun listItemsWithWhileLoop(items: List<String>) {
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// Function to demonstrate when statement
fun demonstrateWhenStatement(x: Int) {
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }
}

// Function to demonstrate when statement with different object types
fun demonstrateWhenWithAnyObject(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

// Function to check if a value fits in a range using when statement
fun demonstrateWhenInRange(x: Int, y: Int) {
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

// Function to check if values are out of range
fun checkOutOfRange(items: List<String>) {
    if (items.size !in items.indices) {
        println("list size is out of valid list indices range, too")
    }
}

// Function to iterate over a range of values
fun iterateOverRange() {
    for (x in 1..5) {
        print(x)
    }
    println()
}

// Function to iterate over a range with progression
fun iterateWithProgression() {
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
    println()
}

// Function to demonstrate lambda operations on a list
fun demonstrateLambda(items: List<String>) {
    items
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

// Function to check the length of a string
fun checkStringLength(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

// Nested class to demonstrate inner class functionality
class NestedClass {
    fun nestedFunction() {
        println("This is a function of the nested class")
    }
}

// Interface to demonstrate interface usage
interface ExampleInterface {
    fun interfaceMethod()
}

// Implementation of ExampleInterface
class InterfaceImplementation : ExampleInterface {
    override fun interfaceMethod() {
        println("Interface implementation")
    }
}

// Parent class to demonstrate inheritance
open class ParentClass {
    open fun parentMethod() {
        println("Method of the parent class")
    }
}

// Child class overriding a method from ParentClass
class ChildClass : ParentClass() {
    override fun parentMethod() {
        println("Method overridden in the child class")
    }
}

// Turtle class to demonstrate usage of `with`
class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {
        println(degrees)
    }

    fun forward(pixels: Double) {
        println(pixels)
    }
}
