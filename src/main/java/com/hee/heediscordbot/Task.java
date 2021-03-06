package com.hee.heediscordbot;

public class Task {

    private static final String PREFIX = "-";

    private String taskName;
    private String taskDesc;

    public Task(String taskName){
        this.taskName = taskName;
    }

    public Task(String taskName, String taskDesc){
        this.taskName = taskName;
        this.taskDesc = taskDesc;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    @Override
    public String toString() {
        return taskName + ": \n \t" + taskDesc;
    }
}
