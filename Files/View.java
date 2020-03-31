import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class View {

	public static void main(String[] args) {
		
		 Scanner entrada = new Scanner(System.in);
		 String nomeMaterial;
		 String valorCoeficiente;
		 newMaterial modelMaterial = new newMaterial();
		 int option;
		 
		 int tipoDado = 0;
		 
		 try {
			 int count = 0;
			 FileInputStream arquivo = new FileInputStream("Materials.txt");
			 InputStreamReader input = new InputStreamReader(arquivo);
			 BufferedReader br = new BufferedReader(input);
			 
			 String linha = new String();
			 
			 while(count == 0) {
				 linha = br.readLine();
				 
				 if(linha == null) {
					 cadastrarPadrao();
				 }
				 count++;
			 }
			 
		 }catch(Exception e) {
			 System.out.println("Erro: "+e);
		 }
		 
		 System.out.println("Escolha o que deseja fazer agora");
		 System.out.println("1 - Calcular dilatação linear");
		 System.out.println("2 - Calcular dilatação superficial");
		 System.out.println("3 - Calcular dilatação volumétrica");
		 System.out.println("4 - Exibir materiais");
		 System.out.println("5 - Incluir material");
		 System.out.println("6 - Excluir material");
		 System.out.println("0 - Sair");
		 option = entrada.nextInt();
		 
		 while(option != 0){
			 switch(option){
			 case 1:
				 break;
			 case 2:
				 break;
			 case 3:
				 break;
			 case 4:
				 System.out.println("Materiais cadastrados:");
				 
				 try {
					 tipoDado = 0;
					 FileInputStream arquivo = new FileInputStream("Materials.txt");
					 InputStreamReader input = new InputStreamReader(arquivo);
					 BufferedReader br = new BufferedReader(input);
					 
					 String linha = new String();
					 
					 while(linha != null) {
						 linha = br.readLine();
						 
						 if(linha != null) {
							 if(tipoDado == 0) {
								 System.out.println("Nome: "+linha);
							 }
							 else {
								 System.out.println("Valor coeficiente: "+linha);
								 System.out.println("<----------------------------------------------------->");
							 }
							 
						 }
						 
						 if(tipoDado == 0) {
							 tipoDado++;
						 }
						 else {
							 tipoDado--;
						 }
					 }
					 System.out.println("*************************************************************");
					 
				 }catch(Exception e) {
					 System.out.println("Não foi possível listar os materiais. Tente incluir um novo material no menu");
				 }
				 break;
			 case 5:
				 
				 System.out.println("Digite o nome do material que será adicionado: ");
				 nomeMaterial = entrada.next();
				 
				 System.out.println("Digite o valor do novo material que será adicionado: ");
				 valorCoeficiente = entrada.next();
				 
				 modelMaterial.writeMaterial(nomeMaterial, valorCoeficiente);
				 
				 break;
			 case 6:
				 break;
			 default:
				 break;
			 }
			 System.out.println("Escolha o que deseja fazer agora");
			 System.out.println("1 - Calcular dilatação linear");
			 System.out.println("2 - Calcular dilatação superficial");
			 System.out.println("3 - Calcular dilatação volumétrica");
			 System.out.println("4 - Exibir materiais");
			 System.out.println("5 - Incluir material");
			 System.out.println("6 - Excluir material");
			 System.out.println("0 - Sair\n");
			 option = entrada.nextInt();
		 }
		 
		 System.out.println("\nObrigado por utilizar o software!\n");

	}
	
	public static void cadastrarPadrao() {
		try {
			FileOutputStream arquivo = new FileOutputStream("Materials.txt", true);
			PrintWriter pr = new PrintWriter(arquivo);
			
			for(int i = 0; i <= 10; i++) {
				 switch(i) {
				 	
					 case 0:
						 pr.println("Chumbo");
						 pr.println(27 * (Math.pow(10, -6)));
				     break;
				     
					 case 1:
						 pr.println("Zinco");
						 pr.println(26 * (Math.pow(10, -6)));
					 break;
					     
					 case 2:
						 pr.println("Alumínio");
						 pr.println(22 * (Math.pow(10, -6)));
					 break;
					     
					 case 3:
						 pr.println("Prata");
						 pr.println(19 * (Math.pow(10, -6)));
					 break;
					     
					 case 4:
						 pr.println("Cobre");
						 pr.println(17 * (Math.pow(10, -6)));
					 break;
					     
					 case 5:
						 pr.println("Ouro");
						 pr.println(15 * (Math.pow(10, -6)));
					 break;
					     
					 case 6:
						 pr.println("Ferro");
						 pr.println(12 * (Math.pow(10, -6)));
					 break;
					     
					 case 7:
						 pr.println("Platina");
						 pr.println(9 * (Math.pow(10, -6)));
					 break;
					     
					 case 8:
						 pr.println("Vidro (comum)");
						 pr.println(8 * (Math.pow(10, -6)));
					 break;
					     
					 case 9:
						 pr.println("Tungstênio");
						 pr.println(4.3 * (Math.pow(10, -6)));
					 break;
					 
					 case 10:
						 pr.println("Vidro (pyrex)");
						 pr.println(3 * (Math.pow(10, -6)));
				     break;
				 }
			 }
			
			pr.close();
			arquivo.close();
			
		}catch(Exception e){
			
			System.out.println("Deu erro pra escrever");
			
		}
	}

}
