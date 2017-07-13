package zevatron.com.br.orgulhogeek.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static List<Filme>itensFilme = new ArrayList<Filme>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    public static Map<String,Filme> itemFilme_Map = new HashMap<String, Filme>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
        addItemFilme(new Filme("1","Rambo 1","1982. Rambo (Sylvester Stallone) é um veterano da Guerra do Vietnã que é preso injustamente pelo xerife Teasle (Brian Dennehy), mas consegue fugir e promove uma guerra não só contra o policial mas contra toda uma cidade, causando pânico e destruição, que é o que ele sabe fazer de melhor."));
        addItemFilme(new Filme("2","Rambo 2 - A Missão","1985. John Rambo (Sylvester Stallone) está cumprindo pena em uma penitenciária federal quando recebe uma proposta: se participar de uma missão suicida (que consiste em localizar prisioneiros americanos) no sudeste asiático será perdoado e reintegrado ao exército. Ele concorda mas não imaginava que seria traído pelos compatriotas, que não querem de fato nenhuma prova de prisioneiros, pois isto acarretaria gastos de 2 bilhões de dólares para libertá-los. Com isso, Rambo acaba sendo abandonado pelos americanos em território inimigo." ));
        addItemFilme(new Filme("3","Rambo 3","1988. Veterano (Sylvester Stallone) da Guerra do Vietnã refugia-se em mosteiro budista, em busca de paz espiritual. O retiro é interrompido quando ele decide libertar seu mentor, que caiu nas mãos dos soviéticos, durante a ocupação do Afeganistão."));

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    private static void addItemFilme(Filme filme){
        itensFilme.add(filme);
        itemFilme_Map.put(filme.id,filme);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
//    Minha classe de Filme Orgulho Geek
    public static class Filme{
        public String id;
        public String imagem;
        public String titulo;
        public String detalhes;
        public String likes;

        public Filme(String id, String titulo, String detalhes) {
            this.id = id;
            this.titulo = titulo;
            this.detalhes = detalhes;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }
}
