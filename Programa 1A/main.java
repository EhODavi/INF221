import java.util.Arrays;

public class main {
	public static String resolve(String entrada) {
		int A, D, Bi[], Ci[];
		String[] linhas = entrada.split("\n"), conteudo;
		String saida = "";
		
		for(int i = 0; i < linhas.length; i += 3) {
			conteudo = linhas[i].split(" ");
				
			A = Integer.parseInt(conteudo[0]);
			D = Integer.parseInt(conteudo[1]);
			
			if(A == 0 && D == 0) {
				break;
			}
			
			Bi = new int[A];
			Ci = new int[D];
			
			conteudo = linhas[i + 1].split(" ");
			
			for(int j = 0; j < A; j++) {
				Bi[j] = Integer.parseInt(conteudo[j]);
			}
			
			conteudo = linhas[i + 2].split(" ");
			
			for(int j = 0; j < D; j++) {
				Ci[j] = Integer.parseInt(conteudo[j]);
			}
			
			Arrays.sort(Bi);
			Arrays.sort(Ci);
			
			if(Bi[0] < Ci[1]) {
				saida += "Y\n";
			} else {
				saida += "N\n";
			}
		}
			
		return saida;
	}
}