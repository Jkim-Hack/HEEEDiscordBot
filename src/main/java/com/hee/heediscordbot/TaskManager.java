package com.hee.heediscordbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private Map<String, List<Task>> tasksList = new HashMap<String, List<Task>>();

    public TaskManager(){

    }


    public void addNewTaskSection(String name){
        tasksList.put(name, new ArrayList<Task>());
    }

    public void addNewTaskSection(String name, ArrayList<Task> tasks){
        tasksList.put(name, tasks);
    }

    /**
     * Edits the existing task from given name
     * @param name name of task
     * @param command given command, of "add", "wipe", "complete"
     * @throws IllegalArgumentException  if bar is zero or negative
     */
    //
    public void editExistingTask(String name, String command){
        if(command.contains("add")){
            String[] str = command.split(" ");
            if(str.length == 3){
                tasksList.get(name).add(new Task(str[1], str[2]));
            } else {
                tasksList.get(name).add(new Task(str[1]));
            }
        } else if(command.contains("complete")){
            String[] str = command.split(" ");
            for (int i = 0; i <tasksList.get(name).size(); i++) {
                if(tasksList.get(name).get(i).equals(str[1])){
                    tasksList.get(name).remove(i);
                }
            }
        } else if(command.contains("wipe")){
            tasksList.clear();
        }
    }



}
