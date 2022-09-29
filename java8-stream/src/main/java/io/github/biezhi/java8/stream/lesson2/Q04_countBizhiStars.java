package io.github.biezhi.java8.stream.lesson2;

import io.github.biezhi.java8.stream.Project;

import java.util.List;

public class Q04_countBizhiStars {

    public static void main(String[] args) {
        List<Project> projects = Project.buildData();
        Integer stars = projects.stream().filter(project -> "biezhi".equals(project.getAuthor()))
                .map(Project::getStars)
                .reduce(0, Integer::sum);

        System.out.println(stars);
    }
}
