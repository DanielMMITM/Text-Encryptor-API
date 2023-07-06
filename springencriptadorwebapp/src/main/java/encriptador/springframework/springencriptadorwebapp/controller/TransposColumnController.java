package encriptador.springframework.springencriptadorwebapp.controller;

import encriptador.springframework.springencriptadorwebapp.service.TransposColumnService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crypt")
public class TransposColumnController {
    @Autowired
    private TransposColumnService service;

    @GetMapping("{text}/{rowsNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String cryptByColumn(@PathVariable String text, @PathVariable int rowsNumber){
        return service.columnCrypt(text, rowsNumber);
    }

    @GetMapping("{text}/{key}")
    @ResponseStatus(HttpStatus.OK)
    public String cryptByKey(@PathVariable String text, @PathVariable String key){
        return service.keyCrypt(text, key);
    }

//    @GetMapping("{text}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<String> cryptText(){
//        return new ResponseEntity<>(service.crypt(), HttpStatus.OK);
//    }
}