from CSE3063F21P1_GRP16.models.Person import Person


class Staff(Person):
    def __init__(self):
        self.staff_id = 0

    def get_staff_id(self) -> int:
        return self.staff_id

    def set_staff_id(self, staff_id: int):
        self.staff_id = staff_id