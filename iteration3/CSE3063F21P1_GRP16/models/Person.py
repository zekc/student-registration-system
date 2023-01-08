from abc import ABC, abstractmethod

class Person(ABC):
    def __init__(self, first_name, last_name, person_mail, ssn):
        self.first_name = first_name
        self.last_name = last_name
        self._person_mail = person_mail
        self._ssn = ssn

    @abstractmethod
    def some_abstract_method(self):
        pass