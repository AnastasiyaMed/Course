package by.pvt.medvedeva.education.command;

import by.pvt.medvedeva.education.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Anastasiya Medvedeva
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;

    }
}