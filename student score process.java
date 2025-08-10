Skip to main content
Google Classroom
Classroom
CSE206
1
Home
Calendar
Gemini
Enrolled
To-do
2
252 CSE324 DBMS Lab Section 1
C
CSE206
1
Archived classes
Settings
Classroom

Md. Saidul Islam
Task filterTask filterTask filter
All
Project CheckPoint 1
No due date
Assigned
Lab Quiz
2
2 submission attachments
No due date
Turned in

Quiz1.java
Java

StudentScoreProcessor.java
Java
Project Proposal
No due date
Assigned
Assignment 5 Class variable and Reference Variable
1
1 submission attachment
No due date
Assigned
Assignment 4 Inheritance
1
1 submission attachment
No due date
Assigned
Online Assignment 3
1
1 submission attachment
No due date
Turned in
Online Assignment 2
1
1 submission attachment
No due date
Assigned
Online Assignment 1
1
1 submission attachment
No due date
Turned in
Assignment 1
1
1 submission attachment
Due Aug 18, 2024, 11:59 PM
Turned in
Project Submission
No due date
Assigned
Comparable Comparator Assignment
No due date
Assigned
Assignment 6, Interface
No due date
Assigned
Completed Part of Quiz 1
No due date
Assigned
Quiz 1
No due date
Assigned
Assignment 5
No due date
Assigned
Assignment 4
No due date
Assigned
Assignment -2 material
No due date
Assigned
Assignment-1 material
No due date
Assigned
CSE-206- Assignment 3
Due Feb 22, 2024
Missing
import java.io.*;
import java.util.*;

public class StudentScoreProcessor {
    public static void main(String[] args) {
        String inputFileName = "Students.txt";
        String outputFileName = "StudentId_results.txt";

        List<Student> students = new ArrayList<>();
        double totalScore = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double score = Double.parseDouble(parts[1].trim());
                students.add(new Student(name, score));
                totalScore += score;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Input file not found: " + exception.getMessage());
            return;
        } catch (IOException exception) {
            System.out.println("Error reading file: " + exception.getMessage());
            return;
        } catch (NumberFormatException exception) {
            System.out.println("Error parsing score: " + exception.getMessage());
            return;
        }

        double averageScore = students.size() > 0 ? totalScore / students.size() : 0;

        double highestScore = 0;
        List<Student> topScorers = new ArrayList<>();
        for (Student student : students) {
            if (student.score > highestScore) {
                highestScore = student.score;
                topScorers.clear();
                topScorers.add(student);
            } else if (student.score == highestScore) {
                topScorers.add(student);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            bw.write(String.format("Average Score: %.2f%n", averageScore));
            bw.write("Top Scorer(s): %n");
            for (Student topScorer : topScorers) {
                bw.write(topScorer.name + " - " + topScorer.score + "%n");
            }
        } catch (IOException exception) {
            System.out.println("Error writing file: " + exception.getMessage());
        }
    }

    static class Student {
        String name;
        double score;

        Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }
}
StudentScoreProcessor.java
Displaying StudentScoreProcessor.java.