package com.test.artemisia;

import com.groupon.artemisia.task.JTaskLike;
import com.groupon.artemisia.task.Task;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Optional;

/**
 * Created by chlr on 12/23/17.
 */
public class SplitterLikeFactory extends JTaskLike {

    public Optional<Config> outputConfig() {
        return Optional.empty();
    }

    @Override
    public Task create(String name, Config config) {
        return new SplitterTask(name, config.getString("content"));
    }

    @Override
    public Config defaultConfig() {
        return ConfigFactory.empty();
    }

    @Override
    public Config paramConfigDoc() { return ConfigFactory.empty(); }

    @Override
    public String info() {
        return "This Task is used to split a string into an array of Strings";
    }

    @Override
    public String desc() {
        return "This Task is used to split a string into an array of Strings";
    }

    @Override
    public String outputConfigDesc() {
        return "";
    }

    @Override
    public String taskName() {
        return "SplitterTask";
    }
}
