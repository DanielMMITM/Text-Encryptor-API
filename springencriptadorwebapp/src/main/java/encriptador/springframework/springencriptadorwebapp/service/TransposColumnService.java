package encriptador.springframework.springencriptadorwebapp.service;

import encriptador.springframework.springencriptadorwebapp.repositories.TransposColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransposColumnService {
    @Autowired
    private TransposColumnRepository transposColumnRepository;

    public String crypt(String text){
        return transposColumnRepository.cryptText(text);
    }
}
