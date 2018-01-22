package Q1
import Q2.Q2_b.conf
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.types._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._

object Q1a {
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val sparkContext = new SQLContext(sc)
    import sparkContext.implicits._
    val fileName = "/Volumes/JetDrive/WPI/17Fall/CS585/Projects/Pro3Q1/Transactions.csv"

    val transactionSchema = StructType(Array(StructField("TransID", IntegerType, true),

      StructField("CustID", IntegerType, true),
      StructField("TransTotal", FloatType, true),
      StructField("NumItems", IntegerType, true),
      StructField("TransDec", StringType, true)
    ))

    val T = sparkContext.read.format("csv").option("header", "false").option("inferSchema", "true").schema(transactionSchema).load(fileName)
    T.show
    T.registerTempTable("Transactions")

    //1
    val T1 = T.filter($"TransTotal" >= 200)
    println("********T1")
    T1.show



    //2
    val T2=T1.groupBy("NumItems").agg(sum("TransTotal").alias("SUM"),
      avg("TransTotal").alias("AVERAGE"),min("TransTotal").alias("MINIMUM"),max("TransTotal").alias("MAXIMUM"))
      .sort($"NumItems")
    println("********T2")
    T2.show

    //3
    val T3=T1.select("CustID").groupBy("CustID").agg(count("CustID").alias("TransCount")).sort($"CustID")
    println("********T3")
    T3.show

    //4
    val T4=T.filter($"TransTotal" >= 600)
    T4.show

    //5
    val T5=T4.select("CustID").groupBy("CustID").agg(count("CustID").alias("TransCount")).sort($"CustID")
    println("********T5")
    T5.show

    //6
    val T6 = T5.as("T5").join(T3.as("T3"), $"T5.CustID" === $"T3.CustID").
      filter(T5.col("TransCount")*3 < T3.col("TransCount")).select($"T3.CustID").sort($"CustID")
    println("********T6")
    T6.show
  }
}
