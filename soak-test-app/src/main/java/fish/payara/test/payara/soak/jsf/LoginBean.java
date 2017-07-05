package fish.payara.test.payara.soak.jsf;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Matt Gill
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private HttpSession session;

    @PostConstruct
    public void init() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public String getUsername() {
        return session.getAttribute("username") == null ? null : (String) session.getAttribute("username");
    }

    public String login() {
        session.setAttribute("username", "test");
        return "people";
    }

    public String logout() {
        session.invalidate();
        return "home";
    }
}
