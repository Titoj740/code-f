public class Empleado {
    private int cedula;
    private String nombre;
    private double sueldo;

    public Empleado(int cedula, String nombre, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double aporteSeguroSocial(double sueldo){
        double aporte=0;
        aporte= sueldo*0.0935;
        return aporte;
    }

    public double impuestoRenta (double sueldo){
        double impuesto = 0;

        if (sueldo<5000){
            impuesto=sueldo*0;
        }else if(sueldo>5000 && sueldo<=10000){
            impuesto=(sueldo-5000)*0.10;
        } else if (sueldo>10000 && sueldo<=18000) {
            impuesto=(sueldo-10000)*0.20;
        } else if (sueldo>18000) {
            impuesto=(sueldo-18000)*0.30;
        }

        return impuesto;
    }

    public double sueldoaRecibir(double sueldo){
        double sueldoaRecibir=0;
        return sueldoaRecibir=sueldo-aporteSeguroSocial(sueldo)-impuestoRenta(sueldo);
    }

    @Override
    public String toString() {
        return "\nEmpleado" +
                "\nCedula: " + cedula +
                "\nNombre: " + nombre +
                "\nSueldo: " + sueldo ;
    }
}
