package encriptador.springframework.springencriptadorwebapp.service;

import encriptador.springframework.springencriptadorwebapp.repositories.EncryptTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {
    @Autowired
    private EncryptTextRepository encryptTextRepository;

    public String columnCrypt(String text, int rowsNumber){
        return encryptTextRepository.cryptByColumn(text, rowsNumber);
    }

    public String keyCrypt(String text, String key){
        return encryptTextRepository.cryptByKey(text, key);
    }
}
