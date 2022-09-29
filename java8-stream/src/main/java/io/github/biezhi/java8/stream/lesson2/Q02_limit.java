package io.github.biezhi.java8.stream.lesson2;

import io.github.biezhi.java8.stream.Project;

import java.util.List;
import java.util.stream.Collectors;

public class Q02_limit {
    public static void main(String[] args) {
        List<Project> projects = Project.buildData();

        projects.stream().limit(2).forEach(project -> System.out.println(project.getName()));

        System.out.println(projects.stream().map(Project::getName).limit(2).collect(Collectors.toList()));
    }
}
