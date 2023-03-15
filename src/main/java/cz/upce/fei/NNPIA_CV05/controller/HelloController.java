package cz.upce.fei.NNPIA_CV05.controller;

import cz.upce.fei.NNPIA_CV05.objects.RequestObject;
import org.springframework.web.bind.annotation.*;

//@Controller se používá pro označení třídy jako Spring MVC Controller.
//@RestController anotace je speciální kontroler pro RESTful Web služby, je to kombinace anotací @Controller a @ResponseBody
@RestController
@RequestMapping("/api/v1")
public class HelloController {
    @GetMapping("")
    public String helloWorld(){
        return "Hello world from Spring boot application";
    }
    @GetMapping("/2/{id}")
    public String pathVariable(@PathVariable String id){
        return "Hello world from Spring boot application with path variable: "+id;
    }
    @GetMapping("/3")
    public String queryVariable(@RequestParam String id){
        return "Hello world from Spring boot application with query variable: "+id;
    }
    @GetMapping("/4")
    public String postController(@RequestBody RequestObject body) {

        return "Hello world from Spring boot application with object body variable: "+body.toString();
    }
}
