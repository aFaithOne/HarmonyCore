package me.lumenowaty.harmonycore.components.interfaces;

import me.lumenowaty.harmonycore.components.annotations.Warning;


public interface Taskable {

    int getId();

    @Warning(info = "Do not use. Please use 'run' method.")
    void startTask();

    void stop();

    void run();

    void setStopTask(Runnable action, int time);
}
