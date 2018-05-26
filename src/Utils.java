import java.util.Random;

public class Utils {
	
	// Distância Euclidiana
	
	public static float distancia_eucl(float x1, float y1, float x2, float y2){ 
		// raiz((x2-x1)^2 + (y2-y1)^2)
		double dx = Math.pow(x2-x1, 2); 
		double dy = Math.pow(x2-y1, 2);
		double resultado = Math.sqrt(dx + dy);
		return (float)resultado;
	}
	
	public static float distancia_eucl(int x1, int y1, int x2, int y2){ 
		// raiz((x2-x1)^2 + (y2-y1)^2)
		double dx = Math.pow(x2-x1, 2); 
		double dy = Math.pow(x2-y1, 2);
		double resultado = Math.sqrt(dx + dy);
		return (float)resultado;
	}

	public static int retornaRandom(int iLimiteMin, int iLimiteMax){
        Random gerador = new Random();
        int numero = gerador.nextInt(iLimiteMax-iLimiteMin+1) + iLimiteMin;
 		
		return numero;
	}

}
