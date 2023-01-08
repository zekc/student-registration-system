class Course:
    def __init__(self, courseName, courseCode, quota, prerequisiteCourse, credits, semester, courseType, sessions, requiredCredits):
        self.__courseName = courseName
        self.__courseCode = courseCode
        self.__quota = quota
        self.__prerequisiteCourse = prerequisiteCourse
        self.__credits = credits
        self.__courseSemesterName = semester
        self.__courseType = courseType
        self.__sessions = sessions
        self.__quotaCounter = 0
        self.__requiredCredits = requiredCredits
        self.__CourseEvents = []
        self.set_events()

    def set_events(self):
        self.__CourseEvents.append(E0Success())
        self.__CourseEvents.append(E1ReTakeCourse())
        self.__CourseEvents.append(E2prerequisite())
        self.__CourseEvents.append(E3HourCollusion())
        self.__CourseEvents.append(E4NoEnoughCredits())
        self.__CourseEvents.append(E5Quota())

    def getCourseEvents(self):
        return self.__CourseEvents

    # getters and setters
    def getcourseName(self):
        return self.__courseName

    def setcourseName(self, courseName):
        self.__courseName = courseName

    def getCourseCode(self):
        return self.__courseCode

    def setCourseCode(self, courseCode):
        self.__courseCode = courseCode

    def getQuota(self):
        return self.__quota

    def setQuota(self, quota):
        self.__quota = quota