package Constants;

public class Constants {
	
	public static String SQL = "insert into cadastro (linguagem,paradigmas,habilidades,anos_exp,certificacao) " +
		     "values (?,?,?,?,?)";
	
	public static String SQLLOGIN = "insert into login (name, email) " +
		     "values (?,?)";
	
	public static String SQLQUERY = "select * from cadastro";
	
	public static String SQLQUERYLOG = "select name, email from login where email = ";
}
