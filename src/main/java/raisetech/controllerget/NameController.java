package raisetech.controllerget;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public  class NameController {


@GetMapping("/names")
    public NameController nameController(@RequestParam(value = "name", defaultValue = "name") String name, @RequestParam(value = "mynumber", defaultValue = "0000000000000000") String mynumber) {
       return new NameController(String.format(name), String.format(mynumber));
    }
    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody UpdateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully delete"));
    }
}