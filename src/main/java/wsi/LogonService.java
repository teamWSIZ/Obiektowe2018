package wsi;

/**
 * Serwis odpowiedzialny za logowanie userów;
 * kontaktuje się z bazą autentykacyjną (haseł)
 * zapamiętuje dane akutalnie zalogowanego usera
 */
public class LogonService {
    private boolean isLoggedIn;
    private String loggedUser;


    public LogonService() {
        isLoggedIn = false;
        loggedUser = null;
    }

    boolean login(String user, String password) {
        if (user.equals("karol") && password.equals("marks#123")) {
            isLoggedIn = true;
            loggedUser = "karol";
        } else if (user.equals("che") && password.equals("victoria")) {
            isLoggedIn = true;
            loggedUser = "che";
        } else {
            isLoggedIn = false;
            loggedUser = null;
        }
        return isLoggedIn;
    }

    void logout(){
        isLoggedIn = false;
        loggedUser = null;
    }

    //true jeśli user jest obecnie zalogowany
    boolean isLoggedIn() {
        return isLoggedIn;
    }


    //zwraca nazwę usera który jest obecnie zalogowany;
    //zwraca "null" jeśli żaden user nie jest zalogowany
    String loggedUser() {
        return loggedUser;
    }

}
