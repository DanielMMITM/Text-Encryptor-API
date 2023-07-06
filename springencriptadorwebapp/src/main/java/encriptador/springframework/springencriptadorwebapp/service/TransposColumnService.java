package encriptador.springframework.springencriptadorwebapp.service;

import encriptador.springframework.springencriptadorwebapp.repositories.CryptTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransposColumnService {
    @Autowired
    private CryptTextRepository cryptTextRepository;

    public String columnCrypt(String text, int rowsNumber){
        return cryptTextRepository.cryptByColumn(text, rowsNumber);
    }

    public String keyCrypt(String text, String key){
        return cryptTextRepository.cryptByKey(text, key);
    }
}
