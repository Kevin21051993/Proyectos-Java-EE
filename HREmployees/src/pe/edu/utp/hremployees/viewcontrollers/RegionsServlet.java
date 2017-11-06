package pe.edu.utp.hremployees.viewcontrollers;

import pe.edu.utp.hremployees.models.Region;
import pe.edu.utp.hremployees.services.HRService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GrupoUTP on 01/07/2017.
 */
@WebServlet(name = "RegionsServlet", urlPatterns = "/regions")
public class RegionsServlet extends HttpServlet {
    // Service Layer access object
    HRService service = new HRService();
    // Action View Paths
    public static String REGIONS_EDIT_URI = "/editRegion.jsp";
    public static String REGIONS_ADD_URI = "/newRegion.jsp";
    public static String REGIONS_INDEX_URI = "/listRegions.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action) {
            case "update": {
                Region region = service.getRegionById(request.getParameter("id"));
                region.setName(request.getParameter("name"));
                String message = service.updateRegion(region) ?
                        "Update success" :
                        "Error while updating";
                log(message);
            }
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(REGIONS_INDEX_URI);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch(action) {
            case "add": {
                actionUri = REGIONS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            }
            case "edit": {
                Region region = service.getRegionById(request.getParameter("id"));
                request.setAttribute("region", region);
                request.setAttribute("action", "edit");
                actionUri = REGIONS_EDIT_URI;
                break;
            }
            default:
                actionUri = REGIONS_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }
}
