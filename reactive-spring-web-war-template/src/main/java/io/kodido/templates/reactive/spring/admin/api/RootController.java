package io.kodido.templates.reactive.spring.admin.api;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/")
public class RootController {



    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" } )
    public Mono<Resource<String>> index(){
        return Mono.just(getIndex());
    }


    public Resource<String> getIndex() {
        Resource<String> result = new Resource<>("API Root");
//
//        Object databases = methodOn(Controller.class).getDatabases();
//        Link databasesLink = linkTo(databases).withRel("link");
//
//        result.add(databasesLink);

        return result;
    }


}
