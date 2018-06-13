package com.scala.practice

object Trie {
  val ALPHABET_SIZE = 26
  class TrieNode(){
    var children = new Array[TrieNode](ALPHABET_SIZE)
    var isEndOfWord = false
    (0 to ALPHABET_SIZE-1).foreach(i=>children(i) = null)
  }
  var root:TrieNode = _
  def insert(key:String): Unit ={
    var pCrawl = root
    var index :Int = -1
    (0 to key.length).foreach(level=>{
      index = key.charAt(level)-'a'
      if(pCrawl.children(index) == null)
        pCrawl.children(index) = new TrieNode
      pCrawl = pCrawl.children(index)
    })
    pCrawl.isEndOfWord = true
  }

  def search(key:String):Boolean = {
    var pCrawl = root
    var index :Int = -1
    (0 to key.length).foreach(level=>{
      index = key.charAt(level)-'a'
      if(pCrawl.children(index) == null)
        return false
      pCrawl = pCrawl.children(index)
    })
    pCrawl != null && pCrawl.isEndOfWord
  }

  def main(args: Array[String]): Unit = {
    val keys = Array("the", "a", "there", "answer", "any", "by", "bye", "their")
    val output = Array("Not present in trie", "Present in trie")
    root = new TrieNode
    (0 to keys.length).foreach(w=>insert(keys(w)))
    if (search("the")) println("the --- " + output(1))
    else println("the --- " + output(0))

    if (search("these")) println("these --- " + output(1))
    else println("these --- " + output(0))

    if (search("their")) println("their --- " + output(1))
    else println("their --- " + output(0))

    if (search("thaw")) println("thaw --- " + output(1))
    else println("thaw --- " + output(0))
  }
}
