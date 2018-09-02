package com.janus.dl1

fun main(args: Array<String>) {

    val question = arrayOf(
            arrayOf(0, 0, 1, 0, 1, 1, 0),
            arrayOf(1, 0, 0, 1, 0, 0, 1),
            arrayOf(0, 1, 1, 0, 0, 1, 0),
            arrayOf(1, 0, 0, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 1, 1, 0, 1)
    )

    val dancingLink = DancingLinks(question)
    dancingLink.solve()
}