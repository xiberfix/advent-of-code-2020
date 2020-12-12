package day8

sealed class Op {
    data class Acc(val arg: Int) : Op()
    data class Jmp(val arg: Int) : Op()
    data class Nop(val arg: Int) : Op()
}

typealias Addr = Int
typealias Program = List<Op>
typealias Bus = (addr: Addr) -> Op

data class State(val acc: Int, val next: Addr)

// Parser

fun String.toOp(): Op = this
    .split(" ")
    .let { (op, s) ->
        val arg = s.toInt()
        when (op) {
            "acc" -> Op.Acc(arg)
            "jmp" -> Op.Jmp(arg)
            "nop" -> Op.Nop(arg)
            else -> error("bad input")
        }
    }

fun String.toProgram(): Program = this
    .lineSequence()
    .map { it.toOp() }
    .toList()

// Runner

fun update(s: State, op: Op) = when (op) {
    is Op.Acc -> s.copy(next = s.next + 1, acc = s.acc + op.arg)
    is Op.Jmp -> s.copy(next = s.next + op.arg)
    is Op.Nop -> s.copy(next = s.next + 1)
}

fun trace(bus: Bus): Sequence<Pair<State, Set<Addr>>> {
    val states = generateSequence(State(0, 0)) { update(it, bus(it.next)) }
    val visited = states.scan(emptySet<Addr>()) { acc, s -> acc + s.next }
    return states.zip(visited)
}


// Part #1

fun simple(p: Program): Bus = { p[it] }

fun part1(input: String): Int {
    val source = input.toProgram()
    val (r, _) = trace(simple(source)).first { (s, visited) -> s.next in visited }
    return r.acc
}


// Part #2

fun swap(op: Op) = when (op) {
    is Op.Nop -> Op.Jmp(op.arg)
    is Op.Jmp -> Op.Nop(op.arg)
    else -> op
}

fun patched(p: Program, addr: Int): Bus = { if (it == addr) swap(p[it]) else p[it] }
fun programs(p: Program) = p.indices.asSequence().map { patched(p, it) }

fun part2(input: String): Int {
    val source = input.toProgram()
    val n = source.size

    val terminal = programs(source)
        .map {
            val (r, _) = trace(it).first { (s, visited) -> s.next in visited || s.next >= n }
            r
        }
        .first { it.next >= n }
    return terminal.acc
}
