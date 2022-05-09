package me.lumenowaty.harmonycore.components.interfaces;

public interface Taskable {

    int getId();

    void stop();

    void run();

    void setStopTask(Runnable runnable, long seconds);
}
