lista_one = list()


lista_one.append('Cristian')
lista_one.append('Jesus')
lista_one.append('Mario')

# Ordenamiento de burbuja
n = len(lista_one)
for i in range(n):
    for j in range(0, n-i-1):
        if lista_one[j] > lista_one[j+1]:
            lista_one[j], lista_one[j+1] = lista_one[j+1], lista_one[j]
print("Lista ordenada con burbuja:", lista_one)

# Ordenamiento por inserción
for i in range(1, len(lista_one)):
    key = lista_one[i]
    j = i-1
    while j >= 0 and key < lista_one[j]:
        lista_one[j+1] = lista_one[j]
        j -= 1
    lista_one[j+1] = key
print("Lista ordenada por inserción:", lista_one)

# Ordenamiento por selección
for i in range(len(lista_one)):
    min_idx = i
    for j in range(i+1, len(lista_one)):
        if lista_one[min_idx] > lista_one[j]:
            min_idx = j
    lista_one[i], lista_one[min_idx] = lista_one[min_idx], lista_one[i]
print("Lista ordenada por selección:", lista_one)

# Imprimir la lista
print("Lista completa:", lista_one)

# Acceder a elementos específicos de la lista
print("Primer elemento:", lista_one[0])
print("Segundo elemento:", lista_one[1])

# Eliminar un elemento de la lista
del lista_one[1]
print("Lista después de eliminar el segundo elemento:", lista_one)

# Longitud de la lista
print("Longitud de la lista:", len(lista_one))
