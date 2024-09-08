package com.example.demo.Tarea.infrastructure.adapters;

import com.example.demo.Tarea.domain.models.InformacionAdicional;
import com.example.demo.Tarea.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {
/*APIS CON LA INFORMACIÓN QUE SE VA A UTILIZAR:
 //https://jsonplaceholder.typicode.com/todos
 //https://jsonplaceholder.typicode.com/users
*/

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {

        this.restTemplate = new RestTemplate();
    }

    @Override
    public InformacionAdicional getInformacionAdicional(Long idTarea) {
        String apiURL = "https://jsonplaceholder.typicode.com/todos/" + idTarea;
        ResponseEntity<JsonPlaceHolderTodo> respuesta = restTemplate.getForEntity(apiURL, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo miPlaceHolderTodo = respuesta.getBody();

        if (miPlaceHolderTodo == null) {
            return null;
        }
        apiURL = "https://jsonplaceholder.typicode.com/users/" + miPlaceHolderTodo.getUserId();
        ResponseEntity<JsonPlaceHolderUsers> respuestaUsuarios = restTemplate.getForEntity(apiURL, JsonPlaceHolderUsers.class);
        JsonPlaceHolderUsers miUsuario = respuestaUsuarios.getBody();
        if (miUsuario == null) {
            return null;
        }
        InformacionAdicional miInfo = new InformacionAdicional(miUsuario.getId(), miUsuario.getName(), miUsuario.getEmail());
        return miInfo;
    }


    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceHolderUsers {
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
