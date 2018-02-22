package util

import java.io.FileInputStream

import com.fasterxml.jackson.databind.JsonNode
import play.libs.Json

object DataLoadService {

  def readData(sourcePath : String ): JsonNode ={


    val stream = new FileInputStream(sourcePath)
     try {  Json.parse(stream) } finally { stream.close() }

  }

}
