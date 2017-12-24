package com.test.artemisia

import com.groupon.artemisia.task.{Task, TaskLike}
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}
import com.groupon.artemisia.util.HoconConfigUtil._

/**
  * Created by chlr on 12/24/17.
  */

class ReducerTask(name: String, content: Array[String]) extends Task(name) {
  override def setup(): Unit = {}

  override def work(): Config = {
    wrapAsStats {
      content.groupBy(x => x)
        .map({ case (key, value) => key -> value.length })
        .foldLeft(ConfigFactory.empty())({
          case (acc, (key, value)) => acc.withValue(key, ConfigValueFactory.fromAnyRef(value))
        }).root
    }
  }

  override def teardown(): Unit = {}
}

object ReducerTask extends TaskLike {

  override val outputConfig: Option[Config] = None
  override def fieldDefinition: Map[String, AnyRef] = Map()
  override def apply(name: String, config: Config): Task = {
    new ReducerTask(name, config.as[List[String]]("content").toArray)
  }
  override val taskName: String = "ReducerTask"
  override def defaultConfig: Config = ConfigFactory.empty()
  override val info: String = "Reducer Task"
  override val desc: String = "This task reduces the list and gets the word count"
  override val outputConfigDesc: String = ""
  override def paramConfigDoc: Config = ConfigFactory.empty()

}
