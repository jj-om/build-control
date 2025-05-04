# Se importa la función createApp desde el paquete app
# Esta función es la encargada de crear y configurar la aplicación Flask
from app import createApp

# Se crea una instancia de la aplicación Flask llamando a createApp()
app = createApp()

# Esta condición verifica si el archivo se está ejecutando directamente
# y no siendo importado como módulo en otro archivo
if __name__ == '__main__':
    # Se ejecuta la aplicación Flask
    # host="0.0.0.0" permite que sea accesible desde cualquier dirección IP
    # port=5000 indica que se usará el puerto 5000
    # debug=True activa el modo de depuración para ver errores detallados
    # use_reloader=False evita que la app se reinicie automáticamente (útil en algunos entornos)
    app.run(host="0.0.0.0", port=5000, debug=True, use_reloader=False)