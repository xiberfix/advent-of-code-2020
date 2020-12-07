package day7

typealias Id = String
typealias Edge = Pair<Id, Int>
typealias Graph = Map<Id, List<Edge>>

// Parser

val CLEAN = Regex("""(no other)|( bags?)|(\.)""")
val EDGE = Regex("""(\d+) (.+)""")

fun String.toEdge() = EDGE.find(this)!!.destructured.let { (count, id) -> id to count.toInt() }

fun String.toNode() = this
    .split(" contain ")
    .let { (id, rest) ->
        val edges = rest
            .splitToSequence(", ")
            .filter { it.isNotEmpty() }
            .map { it.toEdge() }
        id to edges.toList()
    }

fun String.toGraph() = this
    .replace(CLEAN, "")
    .lineSequence()
    .map { it.toNode() }
    .associate { it }


// Part #1

fun countColors(g: Graph, goal: Id): Int {
    val memo = mutableMapOf<Id, Boolean>()
    fun children(v: Id) = g[v] ?: emptyList()

    fun eval(v: Id): Boolean = memo.getOrPut(v, {
        children(v).any { it.first == goal || eval(it.first) }
    })
    g.keys.forEach { eval(it) }
    return memo.values.count { it }
}

fun part1(input: String) = countColors(input.toGraph(), "shiny gold")


// Part #2

fun countRequiredBags(g: Graph, goal: Id): Int {
    val memo = mutableMapOf<Id, Int>()
    fun children(v: Id) = g[v] ?: emptyList()

    fun eval(v: Id): Int = memo.getOrPut(v, {
        children(v).map { eval(it.first) * it.second }.sum() + 1
    })
    return eval(goal) - 1 // exclude 'goal' itself
}

fun part2(input: String) = countRequiredBags(input.toGraph(), "shiny gold")
