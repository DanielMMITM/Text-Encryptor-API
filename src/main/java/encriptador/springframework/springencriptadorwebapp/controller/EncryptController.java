package encriptador.springframework.springencriptadorwebapp.controller;

import encriptador.springframework.springencriptadorwebapp.service.EncryptService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crypt")
public class EncryptController {
    @Autowired
    private EncryptService service;

    @GetMapping("{text}/{rowsNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String cryptByColumn(@PathVariable String text, @PathVariable int rowsNumber){
        return service.columnCrypt(text, rowsNumber);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String cryptByKey(@RequestParam(value = "text") String text, @RequestParam(value = "key") String key){
        return service.keyCrypt(text, key);
    }
}