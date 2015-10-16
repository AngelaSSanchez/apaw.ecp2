package apaw.ecp2.classes;

import apaw.ecp2.web.http.HttpRequest;
import apaw.ecp2.web.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
