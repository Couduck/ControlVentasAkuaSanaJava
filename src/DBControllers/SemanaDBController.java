package DBControllers;

import DBConnection.ConexionDB;
import Models.Producto;
import Models.Semana;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SemanaDBController
{
    private ConexionDB db;

    public SemanaDBController(ConexionDB conexion)
    {
        this.db = conexion;
    }

    public int comprobarTablaSemanasVacia() throws SQLException {
        String instruccionSTR = "select count(*) from semanas";
        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        while (resultados.next())
        {
            return resultados.getInt(1);
        }

        return 999999;
    }

    public void insertarSemanaNueva(Semana semana) throws SQLException {
        String instruccionSTR = "insert into semanas (smn_fecha_inicio, smn_fecha_final, smn_numero_semana, smn_numero_semana_anio, smn_numero_semana_graficas) values (?, ?, ?, ?, ?)";

        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setDate(1, new java.sql.Date(semana.getFechaInicio().getTime()));
        instruccionConValores.setDate(2, new java.sql.Date(semana.getFechaFinal().getTime()));
        instruccionConValores.setString(3,semana.getNumSemana());
        instruccionConValores.setString(4,semana.getAnio());
        instruccionConValores.setString(5,semana.getIdSemanaCombinado());

        instruccionConValores.execute();
    }

    public void generarSemanasAnio() throws SQLException {


    }

    public ResultSet recuperarSemanas() throws SQLException {
        String instruccionSTR = "select * from semanas order by smn_fecha_final desc";

        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public void comprobarSemanas() throws SQLException, ParseException {

        int totalRegistrosSemanas = comprobarTablaSemanasVacia();
        LocalDate currentdate = LocalDate.now();
        Date currentDate2 = new Date();
        //currentDate2 = new GregorianCalendar(2029, Calendar.JANUARY, 5).getTime();


        if(totalRegistrosSemanas > 0)
        {
            ResultSet resultados = recuperarSemanas();
            Date fechaLimiteAnio = null;

            while(resultados.next())
            {
                fechaLimiteAnio = resultados.getDate("smn_fecha_final");
                break;
            }

            if(fechaLimiteAnio.before(new java.sql.Date(currentDate2.getTime())))
            {
                Calendar cal1 = new GregorianCalendar(), cal2 = new GregorianCalendar(); //cal3 = new GregorianCalendar();;
                cal1.setTime(fechaLimiteAnio);
                cal1.setTime(currentDate2);
                cal2.set(currentdate.getYear()+1, Calendar.JANUARY, 1);
                //cal2.set(2029, Calendar.JANUARY, 1);

                if(cal1.compareTo(cal2) > 0)
                {
                    generarSemanasAnio(false, currentdate.getYear());
                    //generarSemanasAnio(false, 2029);
                }

                else
                {
                    generarSemanasAnio(false, currentdate.getYear()+1);
                    //generarSemanasAnio(false, 2030);
                }
            }
        }

        else
        {
            generarSemanasAnio(true, currentdate.getYear());
        }
    }

    public void generarSemanasAnio(boolean primeraVez, int anioLlenar) throws ParseException, SQLException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicioAnio = formato.parse("01/01/" + anioLlenar);
        Calendar cal = new GregorianCalendar();

        cal.setTime(fechaInicioAnio);

        if(primeraVez)
        {
            int cantidadAumentarDias = 0;

            switch (cal.get(Calendar.DAY_OF_WEEK))
            {
                case 1:
                case 2:
                case 3:
                case 4:
                    cantidadAumentarDias = -1;

                    break;

                case 5:
                case 6:
                case 7:
                    cantidadAumentarDias = 1;
                    break;

            }

            int diaEnCuestion = cal.get(Calendar.DAY_OF_WEEK);

            while(diaEnCuestion - 1 != 0)
            {
                cal.add(Calendar.DAY_OF_YEAR, cantidadAumentarDias);

                diaEnCuestion = cal.get(Calendar.DAY_OF_WEEK);
            }
        }

        else
        {
            ResultSet resultados = recuperarSemanas();
            Date fechaLimiteAnio = null;

            while(resultados.next())
            {
                fechaLimiteAnio = resultados.getDate("smn_fecha_final");
                cal.setTime(fechaLimiteAnio);
                cal.add(Calendar.DAY_OF_YEAR, 1);
                break;
            }
        }

        int numSemana;

        for(numSemana = 1; numSemana < 53; numSemana++) {

            Date fechaInicio = cal.getTime();
            String anioFecha = String.valueOf(anioLlenar);
            DecimalFormat formatoNumSemana = new DecimalFormat("00");
            String numSemanaCorrecto = formatoNumSemana.format(numSemana);

            String SemanaBI = anioFecha + numSemanaCorrecto;

            cal.add(Calendar.DAY_OF_YEAR, 6);
            Date fechaFinal = cal.getTime();

            Semana semanaNueva = new Semana(fechaInicio, fechaFinal, anioFecha, numSemanaCorrecto, SemanaBI);
            cal.add(Calendar.DAY_OF_YEAR, 1);

            insertarSemanaNueva(semanaNueva);
        }
    }


    public String determinarSemanaActual() throws SQLException {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());

        int diaEnCuestion = cal.get(Calendar.DAY_OF_WEEK);

        while(diaEnCuestion - 1 != 0)
        {
            cal.add(Calendar.DAY_OF_YEAR, -1);

            diaEnCuestion = cal.get(Calendar.DAY_OF_WEEK);
        }

        String instruccionSTR  = "select * from semanas \n where smn_fecha_inicio = \"" + new java.sql.Date(cal.getTime().getTime())+ "\"";

        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        resultados.next();

        return resultados.getString("smn_numero_semana_graficas");
    }
}
