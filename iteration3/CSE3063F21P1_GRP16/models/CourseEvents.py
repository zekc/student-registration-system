from typing import List
from abc import ABCMeta,abstractmethod

class CourseEvents(metaclass=ABCMeta):
    @abstractmethod
    def toString(self) :
        pass


    @abstractmethod
    def getStudents(self):
        pass
