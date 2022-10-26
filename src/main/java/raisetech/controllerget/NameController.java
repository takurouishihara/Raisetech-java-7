package raisetech.controllerget;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static java.util.Map.of;


@RestController
public  class NameController {


    @GetMapping("/names")
    public  NameResponse nameResponse(@RequestParam(value = "name", defaultValue = "name") String name, @RequestParam(value = "myNumber", defaultValue = "0000000000000000") String myNumber) {
        return (NameResponse) Map.of("name", name, "myNumber", myNumber);
        //  return new NameResponse(String.format(name), String.format(myNumber));
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
        return ResponseEntity.ok(of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(of("message", "name successfully delete"));
    }
}
