def suma(a,b):
    return a+b

def resta(a,b):
    return a-b

def multiplicacion(a,b):
    return a*b

def division (a,b):
    if b == 0:
        return "Error: No puedes dividir entre cero"
    else:
        return a/b
    

print ("Bienvenido a tu calculadora de python \n")

while True:
    print ("OPCIONES: \n")
    print ("SUMAR: +")
    print ("RESTAR: -")
    print ("MULTIPLICAR: *")
    print ("DIVIDIR: /")
    print ("Salir: 0000\n")

    opcion = input ("Selecciona una opción: ")

    if opcion == '+':
        num1 = float(input("Ingresa el primer número: "))
        num2 = float(input("Ingresa el segundo número: "))
        print(suma(num1, num2))
        print("\n")
    
    elif opcion == '-':
        num1 = float(input("Ingresa el primer número: "))
        num2 = float(input("Ingresa el segundo número: "))
        print(resta(num1, num2))
        print("\n")

    elif opcion == '*':
        num1 = float(input("Ingresa el primer número: "))
        num2 = float(input("Ingresa el segundo número: "))
        print(multiplicacion(num1, num2))
        print("\n")

    elif opcion == '/':
        num1 = float(input("Ingresa el primer número: "))
        num2 = float(input("Ingresa el segundo número: "))
        print(division(num1, num2))
        print("\n")

    elif opcion == '0000':
        print("¡Hasta pronto!")
        print("\n")
        break

    else:
        print("Opcion no valida. Por favor, selecciona una opcion valida")

