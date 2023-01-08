from typing import List

from models import Student, Course
from models.Lecturer import Lecturer


class Advisor(Lecturer):
    def __init__(self, new_name: str, new_last_name: str):
        self.first_name = new_name
        self.last_name = new_last_name
        self.course_list = []
        self.student_list = []

    def course_approval(self, student: Student, waiting_courses: List[Course]) -> str:
        # Removing disapproved courses from approval list and adding reminding parts to the transcript through registration system
        dis_approved_courses = []
        for i in range(len(waiting_courses)):
            if waiting_courses[i].required_credits > student.transcript.completed_credits:
                print("Advisor: The course: " + waiting_courses[i].course_code + " not added due to credits")
                waiting_courses[i].course_events[4].students.append(student)  # student doesnt have needed number of credits
                dis_approved_courses.append(i)

        for i in range(len(dis_approved_courses)):
            waiting_courses.pop(dis_approved_courses[i])

        for i in range(len(waiting_courses)):
            waiting_courses[i].course_events[0].students.append(student)  # successfully added student to i'th course
            waiting_courses[i].quota_counter += 1

            for j in range(len(student.transcript.failed_courses)):
                if waiting_courses[i].course_code == student.transcript.failed_courses[j].course_code:
                    print("Advisor: The course: " + waiting_courses[i].course_code + " was taken again by the student")
                    waiting_courses[i].course_events[1].students.append(student)  # student retake the course
                    break

        if student.student_utils.course_registration_system.add_approved_courses_to_transcript(student, waiting_courses):
            return "Successfully Approved"
        else:
            return "Failed to register"

    def adding_checked_courses(self, student: Student, courses: List[Course]) -> str:
        # Method sends checked courses to registration system
        if student.student_utils.course_registration_system.add_approved_courses_to_transcript(student, courses):
            return "Successfully Approved"
        else:
            return "Failed to register"

    @property
    def student_list(self):
        return self.student_list

    @student_list.setter
    def student_list(self, student_list):
        self.student_list = student_list