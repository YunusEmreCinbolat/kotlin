fun main() {
    val list1 = listOf(3, 1, 4)
    val list2 = listOf(2, 5, 6)

    val mergedAndSorted = mergeAndSortLists(list1, list2)

    println("Birleştirilmiş ve Sıralanmış Liste: $mergedAndSorted")
}

fun mergeAndSortLists(list1: List<Int>, list2: List<Int>): List<Int> {
    val mergedList = mutableListOf<Int>()

    mergedList.addAll(list1)
    mergedList.addAll(list2)

    for (i in 0 until mergedList.size - 1) {
        for (j in i + 1 until mergedList.size) {
            if (mergedList[i] > mergedList[j]) {
                val temp = mergedList[i]
                mergedList[i] = mergedList[j]
                mergedList[j] = temp
            }
        }
    }

    return mergedList
}
