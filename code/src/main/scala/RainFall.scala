/**
  * Created by thusitha on 4/8/18.
  * function: mean(town, strng) should return the average of rainfall for the city town and the strng data or data1 (In R this function is called avg).
    function: variance(town, strng) should return the variance of rainfall for the city town and the strng data or data1.
  */
package org.tnc.scala.snippets
import scala.collection.immutable.Range
import scala.math.pow
object Rain extends App{

  def findCityData(town: String, dataLine : String) = {
    val dataList = dataLine.split("\\n").toList

    val townData = dataList.find( line => town.equals(line.split(":")(0)))
    val monthsWithTemps = townData match {
      case Some(data) => data.split(":")(1).split(",").toList
      case None => Nil
    }
    monthsWithTemps.map(_.split(" ")(1).toDouble)
  }

  def mean(town: String, strng: String): Double = {
    val temps = findCityData(town, strng)
    if (temps.isEmpty) -1.0 else temps.reduce(_+_)/temps.size.toDouble
  }

  def variance(town: String, strng: String): Double = {
    val temps = findCityData(town, strng)
    if (temps.isEmpty) -1.0 else {
    val mu = mean(town, strng)
    temps.map(x => pow((x-mu), 2)).reduce(_+_)/temps.size.toDouble
    }
  }

}
