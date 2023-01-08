from models.Person import Person


class Staff(Person):
    def __init__(self):
        self._staff_id = 0

    def get_staff_id(self) -> int:
        return self._staff_id

    def set_staff_id(self, staff_id: int):
        self._staff_id = staff_id