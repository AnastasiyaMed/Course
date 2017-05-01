package by.pvt.medvedeva.education.command;
import javax.servlet.http.HttpServletRequest;
/**
 * @author Anastasiya Medvedeva
 */
public interface ActionCommand {
String execute(HttpServletRequest request);
}