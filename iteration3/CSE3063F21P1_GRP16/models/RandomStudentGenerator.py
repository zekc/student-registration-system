import random

first_names = [ "Charmane", "Guillema", "Ruthann", "Welsh", "Garold", "Mitchael", "Noellyn", "Antony", "Rafaellle", "Russ", "Noami", "Adler", "Michelle", "Farleigh", "Hertha", "Lucias", "Benedetta", "Fawnia", "Rebe", "Linda", "Mathian", "Consuela", "Cal", "Kalle", "Natale", "Athena", "Hervey", "Tilly", "Veronike", "Karl", "Joann", "Raddy", "Darren", "Lynnet", "Kaycee", "Brendin", "Oliy", "Magnum", "Tedra", "Marlin", "Velvet", "Helaine", "Rebecca", "Natty", "Micky", "Perla", "Kelli", "Garik", "Lucie", "Hollis" ]

last_names = ["Gallety", "Scurman", "Gulliman", "Domini", "De Caroli", "Durrance", "Wozencroft", "Jaqueme", "Campsall", "Chicchelli", "Twydell", "Nowak", "McMillam", "Frood", "Treharne", "Dennant", "Clewes", "Moring", "Rankcom", "O'Hanley", "Snodin", "Grigoriev", "Benterman", "Waber", "Skouling", "Renihan", "Wilks", "Musson", "Letham", "Mcettrick", "Vieyra", "Tatnell", "Cymper", "Muckeen", "Cuxon", "Itzik", "Late", "Sugden", "Wodeland", "MacGahy", "Garric", "Bockman", "Denisovich", "Basnett", "Welham", "Luchelli", "Boome", "Gannaway", "Saice", "Greenhough"]

class Student:
    def __init__(self, first_name, last_name, courses):
        self.first_name = first_name
        self.last_name = last_name
        self.courses = courses

    def add_semester(self, courses, semester_no, semester_name):
        self.courses = courses
        self.semester_no = semester_no
        self.semester_name = semester_name

class CourseRegistrationSystem:
    registration_system = None

    def __new__(cls):
        if CourseRegistrationSystem.registration_system is None:
            CourseRegistrationSystem.registration_system = object.__new__(cls)
        return CourseRegistrationSystem.registration_system

    @staticmethod
    def get_registration_system():
        return CourseRegistrationSystem()

    @staticmethod
    def get_available_courses(semester_name, courses):
        if semester_name == "FALL":
            return courses[:int(len(courses)/2)]
        else:
            return courses[int(len(courses)/2)]
