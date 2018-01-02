package hillelee.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ProblemSolver {
    @SneakyThrows
    public String solve(Object problem) {
        Class<?> aClass = problem.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CorrectAnswer.class)) {
                return (String) method.invoke(problem);
            }
        }
        throw new RuntimeException("There is no CorrectAnswer annotation");
    }
}
