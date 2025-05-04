# Importación de módulos necesarios de Flask y la conexión a MongoDB
from flask import Blueprint, jsonify, request, abort
from .conexion import getConexion  # Función para obtener la conexión a la base de datos

# Se crea un Blueprint llamado 'routes' para modularizar las rutas de la aplicación
routes = Blueprint('routes', __name__)
# Es un objeto que representa una colección de rutas (endpoints), funciones auxiliares y 
# otros elementos relacionados con una parte específica de la aplicación.

# Ruta principal (raíz) de la API: simplemente devuelve un texto indicando que es la página principal
@routes.route("/", methods=["GET"])
def home():
    return "Home Page"

# Ruta para obtener el personal de una obra específica
# Se espera un parámetro de ruta llamado idObra
@routes.route("/personal/<idObra>", methods=["GET"])
def obtenerPersonalObra(idObra):
    # Se obtiene un parámetro opcional llamado 'query' desde la URL (?query=...)
    query = request.args.get("query")
    
    # Se establece la conexión a la base de datos MongoDB
    db = getConexion()
    collection = db["empleados"]  # Se accede a la colección 'empleados'

    # Se crea un filtro para buscar por idObra (convertido a entero)
    filtro = {"idObra": int(idObra)}
    
    # Si se proporciona un parámetro 'query', se añade al filtro para buscar coincidencias parciales en 'nombre'
    if query:
        filtro["nombre"] = {"$regex": query, "$options": "i"}  # Búsqueda insensible a mayúsculas/minúsculas

    # Se ejecuta la búsqueda en MongoDB y se convierte a una lista, excluyendo el campo '_id'
    resultados = list(collection.find(filtro, {"_id": 0}))

    # Si no se encontraron resultados, se lanza un error 404 con un mensaje personalizado
    if not resultados:
        abort(404, description="No se encontraron resultados para el idObra proporcionado.")

    # Se devuelve la lista de resultados en formato JSON con un código de estado HTTP 200 (OK)
    return jsonify(resultados), 200

# Manejador de errores para el código 404 (no encontrado)
# Devuelve un mensaje de error en formato JSON en lugar del HTML por defecto
@routes.app_errorhandler(404)
def recurso_no_encontrado(e):
    return jsonify({"message": str(e)}), 404