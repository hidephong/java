/**
 * Created by tuanna on 5/19/14.
 */
import play.api.libs.json.Json

val js = Json.obj(
  "key1" -> "alpha",
  "key2" -> 123.345F,
  "key3" -> Json.arr("alpha", "beta")
)

import play.api.libs.json._
import play.api.libs.functional.syntax._

val customReads: Reads[(String, Float, List[String])] =
  (JsPath \ "key1").read[String] and
    (JsPath \ "key2").read[Float] and
    (JsPath \ "key3").read[List[String]]  tupled

customReads.reads(js)