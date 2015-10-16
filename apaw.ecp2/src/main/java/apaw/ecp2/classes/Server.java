package apaw.ecp2.classes;

import apaw.ecp2.web.http.HttpMethod;
import apaw.ecp2.web.http.HttpRequest;
import apaw.ecp2.web.http.HttpResponse;
import apaw.ecp2.web.http.HttpStatus;
import apaw.ecp2.web.presentation.frontController.FrontController;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
