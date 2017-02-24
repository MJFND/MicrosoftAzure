import org.apache.spark.SparkContext;
import org.apache.spark._;

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("HelloWorld").setMaster("local")
    val conext = new SparkContext(conf)
    val textFile = sc.textFile("wasb:///example/data/fruits.txt") 
    val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _) 
    counts.coalesce(1,true).saveAsTextFile("wasb:///example/data/fruitcount.txt")
  }
}
