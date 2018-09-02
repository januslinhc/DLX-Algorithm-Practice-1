package com.janus.dl1

class HeadNode : Node() {

    fun size(): Int {
        var size = 0
        var c = this.right
        while (!(c is HeadNode)) {
            size++
            c = c.right
        }
        return size
    }
}