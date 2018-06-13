package com.scala.practice


sealed trait NodeT[+A] {
  def head: A
  def next: NodeT[A]
}

case class Insert[+A] (val head: A, val next: NodeT[A]) extends NodeT[A] {
  override def toString = s"head: $head, next: $next"
}

object LinkeListEX extends NodeT[Nothing]{
  override def head = throw new NoSuchElementException("head of empty list")
  override def next = throw new UnsupportedOperationException("tail of empty list")
}

object LinkedListDriver extends App {
  val c1 = Insert(1, LinkeListEX)
  val c2 = Insert(2, c1)
  val c3 = Insert(3, c2)

  println(c1)
  println(c2)
  println(c3)
}

