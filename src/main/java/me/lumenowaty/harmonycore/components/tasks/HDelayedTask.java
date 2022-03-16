package me.lumenowaty.harmonycore.components.tasks;

public abstract class HDelayedTask extends HTask {

    protected final int delayed;

    protected HDelayedTask(int delayed) {
        this.delayed = delayed;
    }


}
