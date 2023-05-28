import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lista {

    private Set<Empleado> listaEmpleados;

    public Lista(){
        listaEmpleados=new LinkedHashSet<Empleado>();
    }

    public void agregar(Empleado x){
        listaEmpleados.add(x);
    }

    public boolean empleadoExistente(int cedula){
        for (Empleado x:listaEmpleados){
            if (x.getCedula()==cedula){
                return true;
            }
        }
        return false;
    }

    public boolean modificarEmpleado (int cedula, String nombre, double sueldo){
       for (Empleado x:listaEmpleados){
           if (x.getCedula()==cedula){
               x.setNombre(nombre);
               x.setSueldo(sueldo);
               return true;
           }
       }
       return false;
    }

    public ArrayList mostrarListaEmpleados(){
        ArrayList listado= new ArrayList();
        for (Empleado x:listaEmpleados){
            listado.add(x.toString()+"\n");
        }
        return listado;
    }

    public ArrayList mostrarListaCalculos(){
        ArrayList listadoCalculo= new ArrayList();
        for (Empleado x:listaEmpleados){
            listadoCalculo.add(x.toString()+"\nAportacion al Seguro: "+x.aporteSeguroSocial(x.getSueldo())+"\nImpuestos: "+x.impuestoRenta(x.getSueldo())+"\nSueldo Final: "+x.sueldoaRecibir(x.getSueldo())+"\n");
        }
        return listadoCalculo;
    }
}