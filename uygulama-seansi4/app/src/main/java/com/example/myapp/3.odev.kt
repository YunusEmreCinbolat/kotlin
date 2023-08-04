package com.example.myapp

fun <K,V> findIntersection(map1: Map<K, V>, map2: Map<K, V>): Map<K, V> {
    val intersectionMap = mutableMapOf<K, V>()
    for ((key, value) in map1) {
        if (map2.containsKey(key) && map2.getValue(key) == value) {
            intersectionMap[key] = value
        }
    }
    return intersectionMap
}

fun main() {
    val map1 = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
    val map2 = mapOf(3 to "three", 4 to "four", 5 to "five", 6 to "six")

    val intersection = findIntersection(map1, map2)
    println("Intersection: $intersection")
}
