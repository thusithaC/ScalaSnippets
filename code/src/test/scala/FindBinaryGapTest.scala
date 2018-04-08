package org.tnc.scala.snippets

import org.scalatest.FunSuite

class FindBinaryGapTest extends FunSuite {
  test("basic"){
    assert(FindBinaryGap(10) equals 1)
    assert(FindBinaryGap(4) equals 0)
    assert(FindBinaryGap(9) equals 2)
  }

}