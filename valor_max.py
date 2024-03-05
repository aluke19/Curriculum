def max_valor(lista):
    if not lista:
        return None
    
    maximo = lista[0]

    i = 1

    while i < len(lista):
        if lista[i] > maximo:
            maximo = lista[i]
        i += 1
    return maximo

lista = [1,5,3,5804369834,34, -434]
print("El número más alto de la lista es:", max_valor(lista))
