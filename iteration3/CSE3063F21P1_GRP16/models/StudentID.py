class StudentID:
    def __init__(self, student_entry_year, student_entry_order, student_department):
        self._student_entry_year = student_entry_year
        self._student_entry_order = student_entry_order
        self._student_department = student_department

    def get_student_string(self):
        return f'1501{self._student_entry_year}{self._student_entry_order:03d}'
