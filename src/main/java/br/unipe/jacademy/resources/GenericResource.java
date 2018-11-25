package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.GenericEntity;
import br.unipe.jacademy.services.GenericService;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public abstract class GenericResource<S extends GenericService, E extends GenericEntity> {

    protected ModelAndView view(String path, String name, Object object) {
        ModelAndView modelAndView = new ModelAndView(path);
        modelAndView.addAllObjects(model(name, object));
        return modelAndView;
    }

    protected Map model(String key, Object value) {
        Map<String, Object> model = new HashMap();
        model.put(key, value);
        return model;
    }
}
