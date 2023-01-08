
from typing import List

from CourseEvents import CourseEvents

from Student import Student

class E1ReTakeCourse(CourseEvents):
    def __init__(self):
        self.__students = []

    def toString(self):
        s = "    Total Number of Student who taking the course again: {}\n".format(len(self.__students))
        if len(self.__students) > 0:
            s += "     -List Of students:\n"
        else:
            s += "\n"

        for i in range(len(self.__students)):
            s += "      *{} {}\n".format(self.__students[i].getFirstName(), self.__students[i].getLastName())

        return s