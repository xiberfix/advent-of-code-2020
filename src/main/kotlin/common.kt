package common

fun <T : Comparable<T>> Iterable<T>.boundsOrNull(): Pair<T, T>? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    val init = iterator.next()
    var min = init
    var max = init
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (min > e) min = e
        if (max < e) max = e
    }
    return Pair(min, max)
}

fun <T : Comparable<T>> Sequence<T>.boundsOrNull(): Pair<T, T>? {
    val iterator = iterator()
    if (!iterator.hasNext()) return null
    val init = iterator.next()
    var min = init
    var max = init
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (min > e) min = e
        if (max < e) max = e
    }
    return Pair(min, max)
}
