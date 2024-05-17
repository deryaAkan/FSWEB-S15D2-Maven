package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(bobsTasks, annsTasks, carolsTasks);

        };
        return new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    //Tüm çalışanların üzerindeki tasjları veren metot bu. Hatta bunu getTasks() metodunda da "all" parametresi ile geçerken kullanıyoruz.
    public Set<Task> getUnion(Set<Task> ... sets){
        HashSet<Task> totalTasks = new HashSet<>();

        for(Set<Task> taskSet : sets){
            totalTasks.addAll(taskSet);
        }

        return totalTasks;
    }

    public Set<Task> getIntersection (Set<Task> set1, Set<Task> set2){
        HashSet<Task> intersections = new HashSet<>(set1);
        intersections.retainAll(set2);
        return intersections;
    }
    public Set<Task> getDifferences (Set<Task> set1, Set<Task> set2){
        HashSet<Task> differences = new HashSet<>(set1);
        differences.removeAll(set2);
        return differences;
    }



}
