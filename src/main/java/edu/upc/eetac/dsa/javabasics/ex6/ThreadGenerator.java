package edu.upc.eetac.dsa.javabasics.ex6;

/**
 * Created by kenshin on 30/09/15.
 */
public class ThreadGenerator implements Runnable {
    private Buffer buff;
    String Textaco = "Loki es un dios embaucador de la mitología nórdica, Hijo de los gigantes Farbauti y Laufey, tiene dos hermanos, Helblindi y Býleistr, de los que poco se sabe: 1 En las eddas es descrito como el «origen de todo fraude» y se mezcló con los dioses libremente, llegando a ser considerado por Odín como su hermano hasta el asesinato de Balder, Luego de esto los Æsir lo capturaron y lo ataron a tres rocas, Se liberará de sus ataduras para luchar contra los dioses en el Ragnarök.\n";
    char[] parsed = Textaco.toCharArray();

    public ThreadGenerator(Buffer b) {
        buff = b;
    }

    public void run() {
        for (int i = 0; i < parsed.length; i++) {
            buff.escritura(Textaco.charAt(i));
        }
    }
}
