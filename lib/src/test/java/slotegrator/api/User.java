// Place to keep all user data together.
package slotegrator.api;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
    
public String username;
public String password_change;
public String password_repeat;
public String email;
public String name;
public String surname;
public String currency_code = "EUR";

}
