package com.janus.dl1

class DancingLinks(val question: Array<Array<Int>>) {
    var answer: ArrayList<DancingNode> = ArrayList()
    var solutions: Int = 0
    val head = HeadNode()

    init {
        makeBoard()
    }

    fun makeBoard() {
        val columnNodeList = ArrayList<ColumnNode>()
        var c: Node = head
        for (i in 1..this.question.get(0).size) {
            val columnName = StringBuilder("C")
            columnName.append(i.toString())
            val newColumn = ColumnNode(columnName.toString())
            c.hookRight(newColumn)
            columnNodeList.add(newColumn)
            c = newColumn
        }

        for (i in 0 until this.question.size) {
            var prev: DancingNode? = null
            for (j in 0 until this.question.get(0).size) {
                if (this.question.get(i).get(j) == 1) {
                    val col = columnNodeList.get(j)
                    val newNode = DancingNode(col)

                    if (prev == null)
                        prev = newNode

                    col.up.hookDown(newNode)
                    prev = prev.hookRight(newNode).toDancingNode()
                }
            }
        }
    }

    private fun Node.toDancingNode(): DancingNode {
        return this as DancingNode
    }

    private fun Node.toColumnNode(): ColumnNode {
        return this as ColumnNode
    }

    fun search(idx: Int) {
        if (head.right == head) {
            // Completed
            println("-----------------------------------------")
            println(answer.size)
            answer.forEach { println(it.columnNode.name) }
            println(idx)
            println("-----------------------------------------")

        } else {
            var c = selectMinColumn()
            c.cover()

            var r = c.down
            while (r != c) {
                answer.add(r.toDancingNode())

                var j = r.right
                while (j != r) {
                    j.toDancingNode().columnNode.cover()
                    j = j.right
                }

                search(idx + 1)

                r = answer.removeAt(answer.size - 1)
                c = r.toDancingNode().columnNode

                j = r.left
                while (j != r) {
                    j.toDancingNode().columnNode.uncover()
                    j = j.left
                }
                r = r.down
            }

            c.uncover()
        }
    }

    fun selectMinColumn(): ColumnNode {
        var min = head.right.toColumnNode().size()
        var min_node = head.right

        var c = min_node.right
        while (c != head) {
            if (c.toColumnNode().size() < min) {
                min = c.toColumnNode().size()
                min_node = c
            }

            c = c.right
        }

        return min_node.toColumnNode()
    }

    fun solve() {
        solutions = 0
        answer = ArrayList()
        search(0)
    }
}