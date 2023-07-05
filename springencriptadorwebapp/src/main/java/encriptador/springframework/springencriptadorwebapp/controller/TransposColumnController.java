package encriptador.springframework.springencriptadorwebapp.controller;

import encriptador.springframework.springencriptadorwebapp.service.TransposColumnService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/columncrypt")
public class TransposColumnController {
    @Autowired
    private TransposColumnService service;

    @GetMapping("{text}/{algorithm}/{rowsNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String cryptText(@PathVariable String text, String algorithm, int rowsNumber){
        return service.crypt(text, rowsNumber);
    }

//    @GetMapping("{text}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<String> cryptText(){
//        return new ResponseEntity<>(service.crypt(), HttpStatus.OK);
//    }
}