class ToDoList:
    def __init__(self):
        self.tasks = []

#anadir tarea
    def add_task(self, task):
        self.tasks.append(task)

#borrar tarea
    def remove_task(self, task):
        if task in self.tasks:
            self.tasks.remove(task)

#enseñar las tareas
    def display_tasks(self):
        if self.tasks:
            print("Tareas pendientes:")
            for index, task in enumerate(self.tasks, start=1):
                print(f"{index}. {task}")
        
        else: 
            print("No hay tareas pendientes.")

def get_user_option():
         while True:
            print("\n¿Qué deseas hacer?")
            print("1. Agregar una tarea")
            print("2. Eliminar una tarea")
            print("3. Mostrar todas las tareas")
            print("4. Salir")

            user_input = input("Selecciona una opción (1/2/3/4): ")

            if user_input in ["1","2","3","4"]:
                return int(user_input)
            else:
                print("Opcion invalida. Por favor, selecciona una opcion valida.")

#crear una instancia de la clase ToDoList

todo_list = ToDoList()

while True:
        user_option = get_user_option()

        if user_option == 1:
            task = input("Ingrese la tarea que desea agragar: ")
            todo_list.add_task(task)
        elif user_option == 2:
            task = input("Ingrese la tarea que quiera eliminar: ")
            todo_list.remove_task(task)
        elif user_option == 3:
            todo_list.display_tasks()
        elif user_option == 4:
            print("Saliendo del programa...\n")
            break

