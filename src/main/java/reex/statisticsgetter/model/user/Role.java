package reex.statisticsgetter.model.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class Role implements GrantedAuthority {
    private Long id;

    private RoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
