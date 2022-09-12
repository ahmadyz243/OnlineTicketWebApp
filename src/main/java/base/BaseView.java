package base;

import javax.servlet.http.HttpServlet;

public abstract class BaseView<E, S extends BaseService<E>> extends HttpServlet {
    protected S service;
}
