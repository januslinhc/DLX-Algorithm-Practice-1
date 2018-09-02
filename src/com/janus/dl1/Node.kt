package com.janus.dl1

abstract class Node {
    var left: Node = this
    var right: Node = this
    var up: Node = this
    var down: Node = this

    fun hookDown(node: Node): Node {
        node.down = this.down
        node.down.up = node
        node.up = this
        this.down = node
        return node
    }

    fun hookRight(node: Node): Node {
        node.right = this.right
        node.right.left = node
        node.left = this
        this.right = node
        return node
    }

    fun unlinkLR() {
        this.left.right = this.right
        this.right.left = this.left
    }

    fun relinkLR() {
        this.left.right = this
        this.right.left = this
    }

    fun unlinkUD() {
        this.up.down = this.down
        this.down.up = this.up
    }

    fun relinkUD() {
        this.up.down = this
        this.down.up = this
    }
}