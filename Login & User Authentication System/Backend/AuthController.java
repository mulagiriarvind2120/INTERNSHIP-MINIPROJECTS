import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Response register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new Response(false, "Username already exists");
        }
        userRepository.save(user);
        return new Response(true, "Registration successful");
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return new Response(true, "Login successful");
        }
        return new Response(false, "Invalid credentials");
    }
}

class Response {
    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
