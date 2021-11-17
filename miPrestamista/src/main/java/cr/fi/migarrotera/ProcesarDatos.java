package cr.fi.migarrotera;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ProcesarDatos implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int ingresos = (Integer) delegateExecution.getVariable("ingresos");
        int montoPrestamo = (Integer) delegateExecution.getVariable("montoPrestamo");

        boolean result;
        System.out.println("Ingresos : "+ ingresos + " monto solicitado " + montoPrestamo);

        if(montoPrestamo < (0.80 * ingresos) ){
            result = true;
            System.out.println("El monto solicitado es menor a los ingresos");
        }else{
            result = false;
            System.out.println("El monto solicitado es mayor a los ingresos");
        }

        delegateExecution.setVariable("resultado",result);




    }

}
