import random
from typing import List

from models import Student, Course

class StudentUtils:
    def __init__(self):
        self.selected_courses = []
        self.course_registration_system = CourseRegistrationSystem.get_registration_system()



    def send_to_approve(self, courses: List[Course], student: Student) -> str:
        # Sends to registration system for adding modified list to transcript
        return student.get_advisor().course_approval(student, courses)

    def enroll_the_course(self, student: Student) -> str:
        # this method sends student's selected courses to systems control
        self.selected_courses = self.course_registration_system.check_selected_courses(student, self.selected_courses)
        return self.send_to_approve(self.selected_courses, student)

    def add_course(self, course: Course):
        if course not in self.selected_courses:
            self.selected_courses.append(course)

    def select_random_courses(self, available_courses: List[Course], student: Student):
        print(f"{student.first_name} {student.last_name} is selecting course")
        self.selected_courses.clear()
        random_amount = int(min(max(5, len(available_courses) * random.random()), 1))
        for i in range(random_amount):
            random_class = int(len(available_courses) * random.random())
            self.add_course(available_courses[random_class])

        print(self.enroll_the_course(student))

    def select_the_course(self, courses: List[Course]) -> List[Course]:
        # generate random 5 courses that the student selected
        self.selected_courses = []
        for i in range(5):
            int_random = random.randint(0, len(courses)-1)
            self.selected_courses.append(courses[int_random])
            courses.pop(int_random)
        return self.selected_courses

    def send_to_approvement(self, student: Student, checked_selected_courses: List[Course]) -> List[Course]:
        # student sends the checked courses by the registration system to his/her advisor and advisor returns modified list
        # checkedSelectedCourses = advisor.courseApprovement(student, checkedSelectedCourses)
        # disabled For now
        return checked_selected_courses

    def get_selected_courses(self) -> List[Course]:
        return self.selected_courses

    def set_selected_courses(self, selected_courses: List[Course]):
        self.selected_courses = selected_courses