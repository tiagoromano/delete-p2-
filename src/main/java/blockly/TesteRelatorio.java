package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TesteRelatorio {

public static final int TIMEOUT = 300;

/**
 *
 * @param datahora
 * @return Var
 */
// testeRelatorio
public static Var Executar(Var datahora) throws Exception {
 return new Callable<Var>() {

   private Var dataFormatada = Var.VAR_NULL;
   private Var diretorio = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {

    System.out.println(datahora.getObjectAsString());

    System.out.println(
    cronapi.dateTime.Operations.formatDateTime(datahora,
    Var.valueOf("DD/MM/YYYY HH:mm:ss")).getObjectAsString());

    dataFormatada =
    cronapi.dateTime.Operations.formatDateTime(datahora,
    Var.valueOf("DD/MM/YYYY HH:mm:ss"));

    diretorio =
    Var.valueOf(
    cronapi.io.Operations.fileAppReclycleDir().toString() +
    cronapi.io.Operations.fileSeparator().toString() +
    Var.valueOf("Relatorio").toString() +
    Var.valueOf(".pdf").toString());

    item =
    cronapi.report.Operations.generateReport(
    Var.valueOf("reports/teste.report"), diretorio, cronapi.list.Operations.newList(Var.valueOf("datahora" , datahora)));

    System.out.println(item.getObjectAsString());

    cronapi.io.Operations.fileDownload(item);
    return Var.VAR_NULL;
   }
 }.call();
}

}

