package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.EnderecoEntity;
import br.unipe.jacademy.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class EnderecoResource extends GenericResource<EnderecoService, EnderecoEntity> {

    @Autowired
    private EnderecoService service;

    @GetMapping("/enderecos")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("endereco/adicionar", "enderecos", service.getAll());
        return modelAndView.addAllObjects(novo());
    }


    @PostMapping("/endereco/salvar")
    public ModelAndView salvar(EnderecoEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/endereco/editar/{idendereco}")
    public ModelAndView editar(@PathVariable("idendereco") Long idendereco) {
        Optional<EnderecoEntity> optional = service.getPorId(idendereco);
        ModelAndView modelAndView = view("endereco/editar", "endereco", optional.get());
        return modelAndView.addAllObjects(model("enderecos", service.getAll()));
    }

    @GetMapping("/endereco/excluir/{idendereco}")
    public ModelAndView excluir(@PathVariable("idendereco") Long idendereco) {
        service.excluirPorId(idendereco);
        return inicio();
    }

    private Map novo(){
        return model("endereco", new EnderecoEntity());
    }
}
