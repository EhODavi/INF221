import java.util.Arrays;
import java.util.Comparator;

class team {
	int numero;
	int pontuacaoTotal;
	int totalCestasFeitas;
	int totalCestasRecebidas;
}

public class main {
	public static String resolve(String entrada) {
		int N;
		int X;
		int Y;
		int Z;
		int W;
		team[] teams;
		String[] linhas;
		String[] conteudo;
		String saida;
		
		linhas = entrada.split("\n");
		N = Integer.parseInt(linhas[0]);
		teams = new team[N];
		saida = "";
		
		for(int i = 0; i < N; i++) {
			teams[i] = new team();
            teams[i].numero = i + 1;
            teams[i].pontuacaoTotal = 0;
            teams[i].totalCestasFeitas = 0;
            teams[i].totalCestasRecebidas = 0;
        }
		
		for(int i = 1; i < linhas.length; i++) {
			conteudo = linhas[i].split(" ");
			
			X = Integer.parseInt(conteudo[0]);
			Y = Integer.parseInt(conteudo[1]);
			Z = Integer.parseInt(conteudo[2]);
			W = Integer.parseInt(conteudo[3]);
			
			teams[X - 1].totalCestasFeitas += Y;
            teams[X - 1].totalCestasRecebidas += W;
            teams[Z - 1].totalCestasFeitas += W;
            teams[Z - 1].totalCestasRecebidas += Y;
            
            if(Y > W) {
                teams[X - 1].pontuacaoTotal += 2;
                teams[Z - 1].pontuacaoTotal += 1;
            } else {
                teams[X - 1].pontuacaoTotal += 1;
                teams[Z - 1].pontuacaoTotal += 2;
            }
		}
		
		Arrays.sort(teams, new Comparator<team>() {
			@Override
			public int compare(final team primeiroteam, team segundoteam) {
				double cestaAverage1;
				double cestaAverage2;
				
			    if(primeiroteam.pontuacaoTotal > segundoteam.pontuacaoTotal) {
			    	return -1;
			    } else if(primeiroteam.pontuacaoTotal == segundoteam.pontuacaoTotal) {
			        if(primeiroteam.totalCestasRecebidas != 0) {
			        	cestaAverage1 = (double)primeiroteam.totalCestasFeitas / (double)primeiroteam.totalCestasRecebidas;
			        } else {
			        	cestaAverage1 = primeiroteam.totalCestasFeitas;
			        }

			        if(segundoteam.totalCestasRecebidas != 0) {
			        	cestaAverage2 = (double)segundoteam.totalCestasFeitas / (double)segundoteam.totalCestasRecebidas;
			        } else {
			        	cestaAverage2 = segundoteam.totalCestasFeitas;
			        }

			        if(cestaAverage1 > cestaAverage2) {
			        	return -1;
			        } else if(cestaAverage1 == cestaAverage2) {
			            if(primeiroteam.totalCestasFeitas > segundoteam.totalCestasFeitas) {
			            	return -1;
			            } else if(primeiroteam.totalCestasFeitas == segundoteam.totalCestasFeitas) {
			                if(primeiroteam.numero < segundoteam.numero) {
			                	return -1;
			                }
			                
			                return 1;
			            }
			            	
			            return 1;
			        }

			        return 1;
			    }

			    return 1;
			}
		});
		
		saida += Integer.toString(teams[0].numero);
		
		for(int i = 1; i < N; i++) {
			saida += " " + Integer.toString(teams[i].numero);
		}
		
		saida += "\n";
		
		return saida;
	}
}