package hello

import java.io.{InputStream, OutputStream, OutputStreamWriter}

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler, RequestStreamHandler}
import org.apache.commons.io.IOUtils

class Handler extends RequestStreamHandler {
  override def handleRequest(input: InputStream, output: OutputStream, context: Context): Unit = {
    val retVal = """{"statusCode": 200,"headers": {"Content-Type": "text/html"},"body": "<html><head><title>Title of the document</title></head><body>The content of the document......</body></html>"}""".stripMargin

    IOUtils.write(retVal.getBytes, output)

  }
}


//  override def handleRequest(input: InputStream, outputStream: OutputStream, context: Context): Unit =  {
//    println("%" * 100)
////    println(s"context:${context}")
////
//    val writer = new OutputStreamWriter(outputStream, "UTF-8")
//    val retVal = """{"statusCode": 200,"headers": {"Content-Type": "text/html"},"body": "Hello world"}""".stripMargin
//    println(s"retVal:$retVal")
//    IOUtils.write(retVal.getBytes, outputStream)
//    println("-" * 100)
//
//
//  }
////  override def handleRequest(input: Request, context: Context): String = {
////    println("%" * 100)
////    println(s"input:${input}")
////    println(s"context:${context}")
//////    val retVal = """{statusCode: 200,headers: {'Content-Type': 'text/html',},body: html}""".stripMargin
////    val retVal = """{"statusCode": 200,"headers": {"Content-Type": "text/html"},"body": "Hello world"}""".stripMargin
////    println(s"retVal:$retVal")
////    println("-" * 100)
////
////    retVal
////  }
//
//}
