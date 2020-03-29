import java.io.FileOutputStream;
import java.io.PrintWriter;

public class newMaterial {
	
	public void writeMaterial(String nome, String coeficiente){
		
		try {
			FileOutputStream arquivo = new FileOutputStream("Materials.txt", true);
			PrintWriter pr = new PrintWriter(arquivo);
			
			pr.println(nome);
			pr.println(coeficiente);
			
			pr.close();
			arquivo.close();
			
		}catch(Exception e){
			
			System.out.println("Deu erro pra escrever");
			
		}
		
	}
}
