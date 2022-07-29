package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int countSubject = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            countSubject += subjects.size();
            for (Subject sub : subjects) {
                sum += sub.getScore();
            }
        }
        return sum / countSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum = 0;
        int countSubject;
        List<Label> scoreByPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String nameStudent = pupil.getName();
            List<Subject> subjects = pupil.getSubjects();
            countSubject = subjects.size();
            for (Subject sub : subjects) {
                sum += sub.getScore();
            }
            scoreByPupil.add(new Label(nameStudent, sum / countSubject));
            sum = 0;
        }
        return scoreByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int countPupil = pupils.size();
        List<Label> scoreBySubject = new ArrayList<>();
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            for (Subject subject : subjects) {
                map.merge(subject.getName(), subject.getScore(), Integer::sum);
            }
        }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer score = entry.getValue();
                scoreBySubject.add(new Label(key, score / countPupil));
            }
        return scoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0;
        List<Label> bestPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String nameStudent = pupil.getName();
            List<Subject> subjects = pupil.getSubjects();
            for (Subject sub : subjects) {
                sum += sub.getScore();
            }
            bestPupil.add(new Label(nameStudent, sum));
            sum = 0;
        }
        bestPupil.sort(Comparator.naturalOrder());
        return bestPupil.get(bestPupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.getSubjects();
            for (Subject subject : subjects) {
                map.merge(subject.getName(), subject.getScore(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer score = entry.getValue();
            scoreBySubject.add(new Label(key, score));
        }
        scoreBySubject.sort(Comparator.naturalOrder());
        return scoreBySubject.get(scoreBySubject.size() - 1);
    }
}
