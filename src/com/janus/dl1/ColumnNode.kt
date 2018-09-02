package com.janus.dl1

class ColumnNode(val name: String) : Node() {
    fun size(): Int {
        var size = 0
        var n = this.down

        while (n != this) {
            size++
            n = n.down
        }
        return size
    }

    fun cover() {
        unlinkLR()
        var i = this.down
        while (i != this) {
            var j = i.right
            while (j != i) {
                j.unlinkUD()

                j = j.right
            }
            i = i.down
        }
    }

    fun uncover() {
        var i = this.up
        while (i != this) {
            var j = i.left
            while (j != i) {
                j.relinkUD()

                j = j.left
            }
            i = i.up
        }
    }
}