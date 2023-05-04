package Lampadas;

//link do problema: https://dojopuzzles.com/problems/lampadas-no-corredor/

public class LampadasCorredor {
    
    public static void main(String[] args) {
        int n = 10; // número de lâmpadas
        
        boolean[] ligadas = new boolean[n]; // array para armazenar o estado das lâmpadas
        
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                ligadas[j - 1] = !ligadas[j - 1]; // alterna o estado da lâmpada
            }
        }
        
        // exibe o estado final de cada lâmpada
        for (int i = 0; i < n; i++) {
            System.out.printf("Lâmpada %d está %s\n", i + 1, ligadas[i] ? "ligada" : "desligada");
        }
    }
    
}
