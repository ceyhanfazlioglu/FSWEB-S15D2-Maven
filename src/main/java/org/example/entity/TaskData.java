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

    public Set<Task> getTasks(String name) {
        if (name == null) return new HashSet<>();
        switch (name.toLowerCase()) {
            case "ann": return this.annsTasks;
            case "bob": return this.bobsTasks;
            case "carol": return this.carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default: return new HashSet<>();
        }
    }

    // HATA 102 ÇÖZÜMÜ: Parametreyi List yerine Varargs (Set<Task>... sets) yaptık.
    // Böylece test kodu ister List yollasın, ister virgülle ayırıp yollasın, Java ikisini de kabul eder.
    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            if (set != null) {
                unionSet.addAll(set);
            }
        }
        return unionSet;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectSet = new HashSet<>(set1);
        intersectSet.retainAll(set2);
        return intersectSet;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> diffSet = new HashSet<>(set1);
        diffSet.removeAll(set2);
        return diffSet;
    }

    public Set<Task> getAnnsTasks() { return annsTasks; }
    public Set<Task> getBobsTasks() { return bobsTasks; }
    public Set<Task> getCarolsTasks() { return carolsTasks; }
    public Set<Task> getUnassignedTasks() { return unassignedTasks; }
}