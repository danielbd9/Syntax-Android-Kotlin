package com.pt.syntax.examples

class RectangleClass {
    var length: Int = 0
    var breadth: Int = 0
    var color: Int = 0xFFFFFF

    fun area(): Int {
        return length * breadth
    }

    fun perimeter(): Int {
        return 2 * (length + breadth)
    }
}
