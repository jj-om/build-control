/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import excepciones.InfraestructuraEmpleadosException;
import excepciones.ObraSinPersonalException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Clase control encargada de gestionar la comunicación con el servicio externo
 * que administra los empleados.
 * 
 * Utiliza la biblioteca OkHttp para realizar solicitudes HTTP y obtener los
 * datos de empleados desde un endpoint REST en formato JSON.
 *
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ControlEmpleados {

    // Cliente HTTP utilizado para realizar solicitudes al servicio externo
    private final OkHttpClient client;

    /**
     * Constructor que inicializa el cliente HTTP.
     */
    public ControlEmpleados() {
        this.client = new OkHttpClient();
    }

    /**
     * Obtiene una lista con los nombres del personal asignado a una obra específica.
     *
     * @param idObra Identificador de la obra a consultar.
     * @return Lista de nombres del personal asignado.
     * @throws InfraestructuraEmpleadosException Si ocurre un problema de red,
     *         si la respuesta es inválida o si hay un error inesperado del servidor.
     * @throws ObraSinPersonalException Si la obra no tiene personal asignado (HTTP 404).
     */
    public List<String> obtenerPersonalObra(Long idObra)
            throws InfraestructuraEmpleadosException, ObraSinPersonalException {

        // Construir la solicitud HTTP GET hacia el endpoint del servicio externo
        Request request = new Request.Builder()
                .url("https://buildcontrol.prega.com/api/personal/" + idObra)
                .build();

        try (Response response = client.newCall(request).execute()) {

            // Si la respuesta no fue exitosa
            if (!response.isSuccessful()) {
                // Si es un error 404, se asume que no hay personal en la obra
                if (response.code() == 404) {
                    throw new ObraSinPersonalException("No se ha encontrado personal asignado a la obra.");
                }
                // Otros errores se consideran problemas de infraestructura
                throw new InfraestructuraEmpleadosException(
                        "Error al obtener el personal. Código HTTP: " + response.code());
            }

            // Convertir el cuerpo de la respuesta a String (esperando un arreglo JSON)
            String responseBody = Objects.requireNonNull(response.body()).string();

            // Convertir el texto JSON a un arreglo de objetos
            JSONArray jsonResponse = new JSONArray(responseBody);

            // Crear la lista para almacenar los nombres del personal
            List<String> nombres = new ArrayList<>(jsonResponse.length());

            // Extraer el nombre de cada objeto del arreglo JSON
            for (int i = 0; i < jsonResponse.length(); i++) {
                nombres.add(jsonResponse.getJSONObject(i).getString("nombre"));
            }

            return nombres;

        } catch (IOException e) {
            // Problemas de red o al ejecutar la solicitud
            throw new InfraestructuraEmpleadosException("Problema de red al obtener el personal.", e);
        } catch (JSONException e) {
            // Problemas al interpretar el JSON recibido
            throw new InfraestructuraEmpleadosException("Respuesta JSON inválida.", e);
        }
    }
}
