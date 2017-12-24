package com.test.artemisia;


import com.groupon.artemisia.task.Task;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import java.util.Arrays;

/**
 * Created by chlr on 12/23/17.
 */
public class SplitterTask extends Task {

    private final String content;

    public SplitterTask(String taskName, String content) {
        super(taskName);
        this.content = content;
    }

    @Override
    public void setup() {}

    @Override
    public Config work() {
        return this.wrapAsStats(ConfigValueFactory.fromIterable(Arrays.asList(content.split("\\s"))));
    }

    @Override
    public void teardown() {}
}
