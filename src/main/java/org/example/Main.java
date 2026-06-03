package org.example;

import org.example.entity.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Parametre sıralaması güncel duruma (assignee, status, priority) göre düzeltildi
        Task t1 = new Task("Alpha", "Login Page", "Ann", Status.IN_PROGRESS, Priority.HIGH);
        Task t2 = new Task("Alpha", "Database Setup", "Ann", Status.ASSIGNED, Priority.MED);
        Task t3 = new Task("Beta", "Payment Integration", "Bob", Status.IN_PROGRESS, Priority.HIGH);
        Task t4 = new Task("Alpha", "Database Setup", "Bob", Status.ASSIGNED, Priority.MED);
        Task t5 = new Task("Beta", "Bug Fix", "Carol", Status.IN_QUEUE, Priority.LOW);
        Task t6 = new Task("Gamma", "Refactoring", null, Status.IN_QUEUE, Priority.LOW);

        Set<Task> annsSet = new HashSet<>(Arrays.asList(t1, t2));
        Set<Task> bobsSet = new HashSet<>(Arrays.asList(t3, t4));
        Set<Task> carolsSet = new HashSet<>(Arrays.asList(t5));
        Set<Task> unassignedSet = new HashSet<>(Arrays.asList(t6));

        TaskData taskData = new TaskData(annsSet, bobsSet, carolsSet, unassignedSet);

        System.out.println("--- MÜDÜRE RAPORLAR ---");

        Set<Task> totalEmployeeTasks = taskData.getUnion(taskData.getAnnsTasks(), taskData.getBobsTasks(), taskData.getCarolsTasks());        System.out.println("1. Tüm Çalışanların Toplam Task Sayısı: " + totalEmployeeTasks.size());

        System.out.println("3. Atanmamış Tasklar: " + taskData.getUnassignedTasks());

        // Metot ismi getIntersection olarak güncellendi
        Set<Task> duplicateTasks = taskData.getIntersection(taskData.getAnnsTasks(), taskData.getBobsTasks());
        System.out.println("4. Birden Fazla Çalışana Atanmış Çakışan Tasklar: " + duplicateTasks);

        System.out.println("\n--- 2. Challenge Kelime Analizi ---");
        Set<String> uniqueWords = StringSet.findUniqueWords();
        System.out.println("Alfabetik Sıralı Kelimeler: " + uniqueWords);
    }
}