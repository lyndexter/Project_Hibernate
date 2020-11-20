import com.lyndexter.managers.SessionManager;
import com.lyndexter.view.View;

public class Main {
  public static void main(final String[] args) throws Exception {
    SessionManager.openSessionFctory();
    new View().show();
    SessionManager.closeSessionFactory();
  }
}
