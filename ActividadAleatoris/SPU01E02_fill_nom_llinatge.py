import random
import sys

while True:
    peticion = sys.stdin.readline().strip()

    if peticion == "salir":
        break

    numero_aleatorio = random.randint(0, 10)

    print(numero_aleatorio)
    
    sys.stdout.flush()