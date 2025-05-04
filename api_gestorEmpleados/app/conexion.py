# Se importa la clase MongoClient de la biblioteca pymongo para conectarse a MongoDB
from pymongo import MongoClient

# Función que establece y devuelve una conexión a la base de datos
def getConexion():
    # URL de conexión al clúster de MongoDB Atlas
    # Contiene el usuario, la contraseña, el nombre del clúster y parámetros adicionales
    url = "mongodb+srv://root:itson@cluster0.bietoqd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

    # Se crea una instancia del cliente de MongoDB utilizando la URL anterior
    client = MongoClient(url)

    # Se accede a la base de datos llamada "GestorEmpleados" dentro del clúster
    db = client["GestorEmpleados"]
    
    # Se devuelve el objeto de base de datos para poder ser utilizado en otras partes de la aplicación
    return db