package com.route.islamic37sat

interface AreaCalculator {
    fun calculate(): Double;
}

class Rectangle(val w: Int, val h: Int) : AreaCalculator {
    override fun calculate(): Double {
        return w * h.toDouble();
    }
}

class Triangle(val w: Int, val h: Int) : AreaCalculator {
    override fun calculate(): Double {
        return .5 * w * h;
    }

}

fun calculateArea(areaCalculator: AreaCalculator): Double {
    return areaCalculator.calculate();
}

fun main() {
    calculateArea(Rectangle(5, 10));
    calculateArea(Triangle(1, 2));
}