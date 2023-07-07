package encriptador.springframework.springencriptadorwebapp.service;

import encriptador.springframework.springencriptadorwebapp.repositories.DecryptTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecryptService {

    @Autowired
    DecryptTextRepository decryptTextRepository;

    public String columnDecrypt(String text, int columnsNumber){
        return decryptTextRepository.decryptByColumn(text, columnsNumber);
    }

    public String keyDecrypt(String text, String key){
        return decryptTextRepository.decryptByKey(text, key);
    }

}
