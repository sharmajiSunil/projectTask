import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object SimpleApp extends App {
  println("Hello World") 
   val logFile = "/Users/home_comp/Desktop/dev/spark/README.md" // Should be some file on your system
    val conf = new SparkConf().setMaster("local").setAppName("Simple Application")
   // conf.setMaster("local");
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
}