class CourseSection:
    def __init__(self, allstudent):
        self.__allstudent = allstudent
        self.__selectedCourses = []

    def getAllstudent(self):
        return self.__allstudent

    def setAllstudent(self, allstudent):
        self.__allstudent = allstudent

    def getSelectedCourses(self):
        return self.__selectedCourses

    def setSelectedCourses(self, selectedCourses):
        self.__selectedCourses = selectedCourses
