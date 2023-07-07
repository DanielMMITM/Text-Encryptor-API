package encriptador.springframework.springencriptadorwebapp.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class DecryptTextRepository {

    public String decryptByColumn(String text, int columnsNumber){
        return "hola";
    }

    public String decryptByKey(String text, String key){
        return "hola2";
    }
}
