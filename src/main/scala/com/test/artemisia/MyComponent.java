package com.test.artemisia;

import com.groupon.artemisia.task.BaseTaskLike;
import com.groupon.artemisia.task.JComponent;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chlr on 12/23/17.
 */
public class MyComponent extends JComponent {

    /**
     * constructor
     * @param name
     */
    public MyComponent(String name) {
        super(name);
    }

    @Override
    public List<? extends BaseTaskLike> tasks() {
       return Arrays.asList(new SplitterLikeFactory(), ReducerTask$.MODULE$);
    }

    @Override
    public Config defaultConfig() {
        return ConfigFactory.empty();
    }

    @Override
    public String info() {
        return "This is a Standard custom Artemisia Component";
    }
}
