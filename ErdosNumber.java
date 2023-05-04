package Erdos;
import java.util.*;

// link do problema: https://dojopuzzles.com/problems/numero-de-erdos/
class ErdosNumber {

    // Classe que representa uma publicação
    static class Publication {
        List<String> authors;

        public Publication(List<String> authors) {
            this.authors = authors;
        }
    }

    // Classe que representa um autor
    static class Author {
        String name;
        int erdosNumber;

        public Author(String name) {
            this.name = name;
            this.erdosNumber = Integer.MAX_VALUE;
        }
    }

    // Função que calcula o número de Erdos de cada autor
    public static void calculateErdosNumbers(List<Publication> publications, String erdosName) {
        // Cria um mapa que mapeia nomes de autores para seus objetos
        Map<String, Author> authorMap = new HashMap<>();
        for (Publication publication : publications) {
            for (String author : publication.authors) {
                if (!authorMap.containsKey(author)) {
                    authorMap.put(author, new Author(author));
                }
            }
        }

        // Cria um grafo que representa as colaborações entre os autores
        Map<Author, List<Author>> graph = new HashMap<>();
        for (Publication publication : publications) {
            List<Author> authorList = new ArrayList<>();
            for (String author : publication.authors) {
                authorList.add(authorMap.get(author));
            }
            for (Author author : authorList) {
                for (Author otherAuthor : authorList) {
                    if (author != otherAuthor) {
                        if (!graph.containsKey(author)) {
                            graph.put(author, new ArrayList<>());
                        }
                        graph.get(author).add(otherAuthor);
                    }
                }
            }
        }

        // Realiza uma busca em largura a partir de Erdos para calcular os números de Erdos dos autores
        Queue<Author> queue = new LinkedList<>();
        Author erdos = authorMap.get(erdosName);
        erdos.erdosNumber = 0;
        queue.offer(erdos);
        while (!queue.isEmpty()) {
            Author author = queue.poll();
            for (Author otherAuthor : graph.getOrDefault(author, new ArrayList<>())) {
                if (otherAuthor.erdosNumber > author.erdosNumber + 1) {
                    otherAuthor.erdosNumber = author.erdosNumber + 1;
                    queue.offer(otherAuthor);
                }
            }
        }

        // Imprime o resultado
        for (Map.Entry<String, Author> entry : authorMap.entrySet()) {
            System.out.printf("%s %s\n", entry.getKey(), entry.getValue().erdosNumber == Integer.MAX_VALUE ? "infinito" : entry.getValue().erdosNumber);
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        List<Publication> publications = new ArrayList<>();
        publications.add(new Publication(Arrays.asList("Paul Erdos", "Alice")));
        publications.add(new Publication(Arrays.asList("Bob", "Charlie", "Alice")));
        publications.add(new Publication(Arrays.asList("Charlie", "Dave", "Eve")));
        calculateErdosNumbers(publications, "Paul Erdos");
    }
}
