package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double rsl = 0D;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
            labels.add(new Label(pupil.name(), rsl / pupil.subjects().size()));
            rsl = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (String key : temp.keySet()) {
            labels.add(new Label(key, (double) temp.get(key) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double rsl = 0D;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
            labels.add(new Label(pupil.name(), rsl));
            rsl = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (String key : temp.keySet()) {
            labels.add(new Label(key, (double) temp.get(key)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}