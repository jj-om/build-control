# Se importa la clase Flask del framework Flask para crear una aplicación web
from flask import Flask

# Se importa el blueprint 'routes' definido en el archivo routes.py dentro del mismo paquete
from .routes import routes

# Función que crea y configura una instancia de la aplicación Flask
def createApp():
    # Se crea una instancia de la aplicación Flask
    app = Flask(__name__)

    # Se registra el blueprint de rutas definido en 'routes'
    # Esto permite modularizar las rutas y organizarlas mejor
    app.register_blueprint(routes)

    # Se devuelve la aplicación ya configurada
    return app