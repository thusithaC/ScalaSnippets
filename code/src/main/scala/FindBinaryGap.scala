/*
* Find the gap between two 1's in a binary number
* i.e.  9 -> 1001 -> 2
*       4 -> 100 ->  0
* */
package org.tnc.scala.snippets

  object FindBinaryGap extends App {
    def apply(number:Int) : Int = {
      def findBinaryGap(currentCount:Int, currentMax:Int, s: List[Char]) : Int =
        s match {
          case Nil => currentMax
          case head::tail => 	if (head equals '0') findBinaryGap(currentCount+1, currentMax, tail)
          else findBinaryGap(0,
            if(currentCount>currentMax) currentCount else currentMax,
            tail)
        }
      val s = number.toBinaryString.toList
      findBinaryGap(0, 0, s)
    }

  }