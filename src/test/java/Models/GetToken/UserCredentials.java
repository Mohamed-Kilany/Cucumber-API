package Models.GetToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserCredentials {
    private String username;
    private String password;
}
