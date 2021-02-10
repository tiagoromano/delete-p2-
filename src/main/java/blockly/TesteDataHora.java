package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TesteDataHora {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// testeDataHora
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {

    item =
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a.datahora from Agenda a where a.datahora = :datahora"),Var.valueOf("datahora",
    Var.valueOf("2021-01-05 19:00:00	")))));

    System.out.println(item.getObjectAsString());

    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.dataHora"), item);
    return Var.VAR_NULL;
   }
 }.call();
}

}

