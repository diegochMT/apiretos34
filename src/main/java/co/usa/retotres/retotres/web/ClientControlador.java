package co.usa.retotres.retotres.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.retotres.retotres.model.Client;
import co.usa.retotres.retotres.service.ClientServicio;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ClientControlador {
    @Autowired
    private ClientServicio clientServicio;
    @GetMapping("/all")
    public List<Client>gClients(){
        return clientServicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client>getClient(@PathVariable ("id")int id){
        return clientServicio.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client clt){
        return clientServicio.save(clt);
    }
    
}
