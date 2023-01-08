import random


class Transcript:
    def __init__(self, student, courses):  # Transcript
        self.student = student
        self.scores = {StudentCourseScore(student, course, random.uniform(4.0)) for course in courses}
        self.calculateGpa()

    def calculateGpa(self):
        if not self.scores:
            self.gpa = 0.0
            return

        scoresDotCredits = sum(score.pointScore() * score.course().getCredits() for score in self.scores)
        credits = sum(score.course().getCredits() for score in self.scores)
        self.gpa = scoresDotCredits / credits if credits != 0 else 0.0

    def getStudent(self):
        return self.student

    def getScores(self):
        return self.scores

    def getGpa(self):
        return self.gpa

    def getPassedCourses(self):
        return [score.course() for score in self.scores if score.pointScore() >= 1.0]

    def getFailedCourses(self):
        return [score.course() for score in self.scores if score.pointScore() < 1.0]

    def getCompletedCredits(self):
        return sum(score.course().getCredits() for score in self.scores)

    def addCourses(self, student, courses):
        if self.student == student:
            newScores = {StudentCourseScore(student, course, random.uniform(4.0)) for course in courses}
            self.calculateGpa()
            return self.scores.update(newScores)
        return False

    def addSemester(self, student, courses, semesterNo, semesterName):
        if self.student == student:
            newScores = {StudentCourseScore(student, course, random.uniform(4.0)) for course in courses}
            self.calculateGpa()
            self.scores.update(newScores)
