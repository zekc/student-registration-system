from typing import List
from CourseEvents import CourseEvents
from Student import Student


class E0Success(CourseEvents):
    def __init__(self):
        self.__students = []
        
    def getStudents(self):
        return self.__students
    
    def toString(self):
        s = "    Total Number of Student who successfully enrolled to the course: {}\n".format(len(self.__students))
        if self.__students:
            s += "     -List Of Students:\n"
            for i in range(len(self.__students)):
                s += "      *{} {}\n".format(self.__students[i].getFirstName(), self.__students[i].getLastName())
        return s