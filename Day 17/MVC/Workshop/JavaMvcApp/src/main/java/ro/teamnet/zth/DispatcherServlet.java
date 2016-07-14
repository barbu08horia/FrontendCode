package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import static jdk.internal.org.objectweb.asm.commons.Method.getMethod;

/**
 * Created by Lion King on 14-Jul-16.
 */
public class DispatcherServlet extends HttpServlet {

    HashMap<String, MethodAttributes> allowedMethods = new HashMap<>();
    //rol de registru
    //key: urlPath
    //val: informatii despere  metoda care va procesa acest url

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, "get");
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String s) {
        Object r = dispatch(req, resp);
        reply(resp, req, r);
        sendExceptionError();
    }

    private void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {

    }

    private void reply(HttpServletResponse resp, HttpServletRequest req, Object r) {

    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getPathInfo();


        MethodAttributes methodAttributes = allowedMethods.get(path);

        if (methodAttributes == null) {
            return "Hello";
        }

            String controllerName = methodAttributes.getControllerClass();

            try {
                Class<?> controllerClass  = Class.forName(controllerName);
                Object controllerInstance = controllerClass.newInstance();
                Method method = controllerClass.
                        getMethod(methodAttributes.getMethodName());
                Object result = method.invoke(controllerInstance);

            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (InstantiationException e){
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        return "Hello";
        }
        /*
        if (path.startsWith("/employees")){
            EmployeeController ec = new EmployeeController();
            String c = ec.getAllEmployees();
            return c;
        }
        if (path.startsWith("/departments")){
            DepartmentController dc = new DepartmentController();
            String d = dc.getAllDepartments();
            return d;

        }*/



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, "post");
    }


    @Override
    public void init() throws ServletException {
        try {
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if (controller.isAnnotationPresent(MyController.class)) {
                    MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method[] controllerMethods = controller.getMethods();
                    for (Method controllerMethod : controllerMethods) {
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                            MyRequestMethod myRequestMethodAnnotation = controllerMethod.getAnnotation(MyRequestMethod.class);
                            String methodUrlPath = myRequestMethodAnnotation.urlPath();
                            String urlPath = controllerUrlPath + methodUrlPath;
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodName(myRequestMethodAnnotation.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());

                            allowedMethods.put(urlPath, methodAttributes);

                        }

                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


