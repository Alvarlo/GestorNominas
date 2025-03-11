package ProgramaNominas;

import java.util.Scanner;

public class GestorNominas {
    public static void main(String[] args) {
        double antiguedad = 0;
        Scanner scn = new Scanner(System.in);

        System.out.println("Salario base:");
        double salarioBase = scn.nextDouble();

        System.out.println(""" 
                La Antigüedad es:
                - 1 Porcentaje
                - 2 Cantidad
                - 3 No hay
                """);

        int respuesta = scn.nextInt();

        if (respuesta == 1){
            System.out.println("Antigüedad (porcentaje):");
            double antiguedadPorcentaje = scn.nextDouble();

            System.out.println("Antigüedad (cantidad):");
            double antiguedadCantidad = scn.nextDouble();
            antiguedad = salarioBase * (antiguedadPorcentaje/100 * antiguedadCantidad);
        }else if (respuesta == 2){
            System.out.println("Antgüedad(numnero)");
            antiguedad = scn.nextDouble();
        }else {

        }

        System.out.println("Incentivos:");
        double incentivos = scn.nextDouble();

        System.out.println("Nocturnidad:");
        double nocturnidad = scn.nextDouble();

        System.out.println("Complementos de convenio:");
        double complementosConvenio = scn.nextDouble();

        System.out.println("Complementos de actividad:");
        double complementosActividad = scn.nextDouble();

        System.out.println("Horas extra (normales):");
        double horasExtra = scn.nextDouble();

        System.out.println("Horas extra(de fuerza mayor):");
        double horasExtraFM = scn.nextDouble();

        System.out.println("Prendas de trabajo:");
        double prendasTrabajo = scn.nextDouble();

        System.out.println("Transporte:");
        double transporte = scn.nextDouble();

        double totalDevengado = salarioBase + antiguedad + nocturnidad + complementosActividad + horasExtra + prendasTrabajo + transporte + complementosConvenio + horasExtraFM + incentivos;

        System.out.println("Total Devengado = " + totalDevengado);


        double percepcionSalarialesSinHE = salarioBase + antiguedad + nocturnidad + complementosConvenio + incentivos + complementosActividad;


        System.out.println("Pagas extra: ");
        double pagaExtra = scn.nextDouble();
        double prorrateoPE = pagaExtra*(salarioBase + antiguedad)/12;

        System.out.println("Prorrateo PE = " + prorrateoPE);

        double percepcionNoSalarialesQueCoticen = 0;

        double bccc = percepcionSalarialesSinHE + percepcionNoSalarialesQueCoticen + prorrateoPE;

        System.out.println("BCCC = " + bccc);

        double minimoBccc = 0;
        double maximoBccc = 0;
        boolean nValido = true;
        do {

            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Rango minimo BCCC: ");
                minimoBccc = sc.nextDouble();

                System.out.println("Rango maximo BCCC: ");
                maximoBccc = sc.nextDouble();

                if (!nValido){
                    nValido = true;
                }

            } catch (Exception e) {
                System.out.println("Número introducido incorrecto");
                nValido = false;
            }

        } while (!nValido);

        double contingenciasComunes = 0;

        if (bccc > minimoBccc && bccc < maximoBccc){
            contingenciasComunes = bccc * 4.70 / 100; //actualmente es 4.83, pero haremos los ejercicios con 4,70
        }else if(bccc < minimoBccc){
            contingenciasComunes = minimoBccc * 4.70 / 100;
        }else if(bccc < maximoBccc){
            contingenciasComunes = maximoBccc * 4.70 / 100;
        }
        System.out.println("Contingencias comunes = " + contingenciasComunes);

        double bccp = bccc + horasExtraFM + horasExtra;
        System.out.println("BCCP = " + bccp);

        System.out.println("""
                El contrato es:
                1- Fijo
                2- Temporal
                """);
        int respuesta2 = scn.nextInt();
        double desempleo = 0;

        if (respuesta2 == 1){
            desempleo = bccp * 1.55 / 100;
        }else {
            desempleo = bccp * 1.66 / 100;
        }

        System.out.println("Desempleo = " + desempleo);

        double fp = bccp * 0.10 / 100;

        System.out.println("FP = " + fp);

        double porcentajeHEN = 0;
        double porcentajeHEFM = 0;
        if (horasExtra!=0){
            porcentajeHEN = horasExtra* 4.70/ 100;
        }

        if (horasExtraFM!=0){
            porcentajeHEFM = horasExtraFM * 2 /100;
        }

        System.out.println("Deducciones horas extra = " + porcentajeHEN);
        System.out.println("Deducciones horas extra FM= " + porcentajeHEFM);

        System.out.println("""
                Percepciones no salarias cotizan:
                1- Si
                2- No
                """);



        int respuesta3 = scn.nextInt();
        double base = 0;


        System.out.println("Porcentaje de retencion IRPF?");
        double irpf = scn.nextDouble();

        if (respuesta3 == 1){
            base = totalDevengado * irpf / 100;
        }else {
            base = (totalDevengado - prendasTrabajo - transporte) * irpf/100;
        }

        System.out.println("Base IRPF = " + base);


        double nomina = totalDevengado - contingenciasComunes - desempleo - fp - porcentajeHEN - porcentajeHEFM - base;

        System.out.println("Nomina = " + nomina);






    }
}
