fun main() {
    val list1 = listOf(3, 1, 4)
    val list2 = listOf(2, 5, 6)

    val mergeSorted = merge(list1, list2)

    println("Birleştirilmiş ve Sıralanmış Liste: $mergeSorted")
}

fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
    val birlestirilmislist = mutableListOf<Int>()

    birlestirilmislist.addAll(list1)
    birlestirilmislist.addAll(list2)

    for (i in 0 until birlestirilmislist.size - 1) {
        for (j in i + 1 until birlestirilmislist.size) {
            if (birlestirilmislist[i] > birlestirilmislist[j]) {
                val temp = birlestirilmislist[i]
                birlestirilmislist[i] = birlestirilmislist[j]
                birlestirilmislist[j] = temp
            }
        }
    }
    return birlestirilmislist
}
