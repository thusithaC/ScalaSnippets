/**
  * Created by thusitha on 4/10/18.
  * If there is a repeated charatcer, replace it with ), else with (
  * eg: thusitha -> ))((())(
  *     dog -> (((
  */


/**I misunderstood the question initially hence the ugly answer here**/
class EncodeDuplicate {

  def duplicateEncode(word: String) = {

    def duplicateEncode(remaniningChars:List[Char], repeaded:Set[Char]) : String = {
      remaniningChars match {
        case head::tail => if (repeaded contains head) ")" + duplicateEncode(tail, repeaded)
                            else "(" + duplicateEncode(tail, repeaded)
        case Nil => ""
      }
    }

    def findDuplicates(chars:List[Char], seen:Set[Char]) : Set[Char] = {
      chars match  {
        case head::tail => if(seen contains head) findDuplicates(tail, seen) + head else findDuplicates(tail, seen+head)
        case Nil => Set[Char]()
      }
    }

    duplicateEncode(word.toLowerCase.toList, findDuplicates(word.toLowerCase.toList, Set[Char]()))
  }
}


/**Elegant answer from another person*/
object Solution {

  def duplicateEncode(word: String) = {
    val wordLower = word.toLowerCase
    val charCounts = wordLower.groupBy(identity).mapValues(_.size)
    wordLower.map(c => if (charCounts(c) > 1) ')' else '(')
  }
}
