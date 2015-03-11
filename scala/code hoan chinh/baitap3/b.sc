import scala.collection.mutable

/**
 * Created by tuanna on 5/19/14.
 */
val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words = mutable.Set.empty[String]
for (word <- wordsArray)  words += word.toLowerCase
words

import scala.collection.immutable.SortedMap
val counts = mutable.Map.empty[String, Int]
def countWords(text: String) = {

   for (rawWord <- text.split("[ ,!.]+")) {
     val word = rawWord.toLowerCase
       val oldCount =
          if (counts.contains(word)) counts(word)
         else 0
        counts += (word -> (oldCount + 1))
      }
   counts
 }

countWords("See Spot run! Run, Spot. Run!")
import scala.collection.immutable.ListMap
ListMap(counts.toList.sortBy{_._2}:_*)
collection.mutable.ListMap[String, Int](counts.toList.sortBy[Int](_._2): _*)

//counts.toSeq.sortWith(_._1 < _._1)
//val sorted = SortedMap[Int, Any]() ++ counts
//sorted
//val t = scala.collection.immutable.TreeMap(counts.toArray:_*)