package raisetech.controllerget;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.Map;
import static java.util.Map.of;

@RestController
@Validated
public  class MyNumberController {

    @GetMapping("/mynumbers")
    public ResponseEntity<Map<String, String>> getName(@RequestParam(value = "name", defaultValue = "name") String name, @RequestParam @Pattern(regexp = "^[0-9]{16}$") String myNumber) {
        return ResponseEntity.ok(Map.of("message", name + " " + myNumber));
    }

    @PostMapping("/mynumbers")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated UpdateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/name/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "マイナンバーの登録確認"));
    }

    @PatchMapping("/mynumbers/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated UpdateForm form) {
        return ResponseEntity.ok(of("message", "マイナンバーの更新確認"));
    }

    @DeleteMapping("/mynumbers/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(of("message", "マイナンバーデータの削除"));
    }
}
