package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.utils.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoryRoom extends AbstractRoom {
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printWelcomeMessage() {

        String space ="       *     \n" +
                "\t.\t \t\t\t\t\n" +
                "\t\t *          ^\n" +
                "\t\t+  *        ^\n" +
                "\t\t  .                      °              *\n" +
                "        +          .'.                      +         o\n" +
                "            '      |o|\n" +
                "                  .'o'.\t\t\to\n" +
                "                  |.-.|                  \n" +
                "     |            '   '  \t\t\t           ,\n" +
                "   - o -\t\t   ( )\t\t\t\t        \\  :  /\n" +
                "\t |\t\t\t\t)\t\t\t\t     `. __/ \\__ .'\n" +
                "\t\t\t\t   ( ) \t\t\t\t     _ _\\     /_ _\n" +
                "\t\t\t\t\t\t\t\t\t    \t/_   _\\\n" +
                "\t\t\t    ^-----------------        .'  \\ /  `.\n" +
                "\t*\t.\t    | Du bist hier. |\t\t    /  :  \\    \n" +
                "\t\t\t    ------------------\t\t\t   '\n" +
                "                   \t    o\t\t\t   \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                " o              +\n" +
                "\t\t\t\t\t\t\t .   *         °    \n" +
                "    ~+\n" +
                "\n" +
                "                                 +\n" +
                "        °           '                 |\n" +
                "               ()    .-.,=\"``\"=.    - o -\n" +
                "                     '=/_       \\     |\n" +
                "                  *   |  '=._    |\n" +
                "                       \\     `=./`,        '\n" +
                "                        '=.__.='`='      *\n" +
                "   +                         +\n" +
                "        O              '       .\n";
        Output.slow(space);

    }

    @Override
    public void enter() {
        String line = "";

        System.out.println("Wie bist du nur hier gelandet?\n" +
                "Alleine im Weltraum.\n" +
                "Vor Stunden schon hast du die Erde, deinen Heimatplaneten, in der Ferne verschwinden sehen.\n" +
                "Wie ist das nur passiert?\n" +
                "Welche Entscheidungen hättest du anders treffen müssen?\n");
        Output.slow("                                                               \n");
        System.out.println("Die Entscheidung, einfach in die Raumkapsel zu steigen, die du verlassen im Wald gefunden hast?\n" +
                "...möglich.\n" +
                "Aber wer kann das jetzt schon sagen.\n" +
                "\n" +
                "Tatsache ist, du bist hier alleine in einer Raumkapsel und driftest immer weiter ins Weltraum.\n" +
                "Willst du den Innenraum der Kapsel weiter inspizieren?\n" +
                "Du kannst folgendes eintippen:\n" +
                "Ja[J], Nein[N] oder Hilfe[H]?");

        getActionLookaroundFromPlayer(line);

        System.out.println("Vor dir an einer Art Steuerkonsole siehst du zwei große Knöpfe.");
        System.out.println("\n" +
                "    .----------.    .----------.\n" +
                "   |           |   |           |\n" +
                "   |  Auto     |   |   Nach    |\n" +
                "   |  Destroy  |   |   Hause   |\n" +
                "   |    [D]    |   |    [H]    |\n" +
                "   '-----------'   '-----------'\n" +
                "   \n" +
                "Welchen möchtest du drücken?  ");

        getActionButtonpressFromPlayer(line);

        Output.slow(  "                                ");

        System.out.println("\nDu drückst >Nach Hause<. Die Steuerkonsole gibt ein unzufrieden klingendes BEEEP von sich.\n" +
                "         ___________________________________________________________________\n" +
                "\t\t|  ERROR: KEINE RECHTE FÜR DIESEN BEFEHL - PASSIERSCHEIN EINREICHEN\t|\n" +
                "\t\t|___________________________________________________________________|\n" +
                "\t\t\n" +
                ">>Passierschein?<<\n" +
                "\t\t __________________________________________________________________________\n" +
                "\t\t| PASSIERSCHEIN: ERKLÄRUNG[E] ZUSAMMENFASSUNG[Z] KURZE ZUSAMMENFASSUNG[K]  |\n" +
                "\t\t|__________________________________________________________________________|");
        System.out.println("Möchtest du die Erklärung[E] hören, die Zusammenfassung[Z], oder die kurze Zusammenfassung[K]?");

        getActionExplanationchoiceFromPlayer(line);

        Output.slow("\n                   .'.\n");
        Output.slow("                   |o|\n");
        Output.slow("                  .'o'.\n");
        Output.slow("                  |.-.|\n");
        Output.slow("                  '   '\n");
        Output.slow("                   ( )\n");
        Output.slow("                    )\n");
        Output.slow("                   ( )\n");



        System.out.println("Die Raumkapsel macht sich auf den Weg Richtung galVerFaGre. \n" +
                "In der Zeit lässt du dir vom Computer erklären, was es mit dieser Behörde auf sich hat.\n");
        Output.slow("...");
        System.out.println("Es klingt nicht gut.\n" +
                "Der Computer spricht eine Warnung aus und bezeichnet die galaktische Bürokratie als >>Kriegswaffe,\n" +
                "die eigentlich mit der Genfer Konvention verboten wurde und nur deshalb noch existiert, weil beim\n" +
                "Antrag auf Schließung bei Anlage B-17 die Unterschrift des Assistenzratsvorsitzenden fehlte.<<\n" +
                "\n" +
                "Besucher geben dem galVerFaGre durchschnittlich einen von fünf Sternen auf galakMaps.\n" +
                "\n" +
                "Dennoch machst du dich auf den Weg, um wieder auf deinen Heimatplaneten Erde zurückzufinden.\n" +
                "Das sind die wichtigen Regeln, die du laut dem Computer wissen musst:\n");
        GameInput.waitTillEnter();

        System.out.println("\n" +
                ".-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.\n" +
                "|  1) Du musst durch alle Räume der Behörde und zum Schluss den         |\n" +
                "|     den Passierschein am Schalter für Heimführungsgesuche abholen.    |\n" +
                "|                                                                       |\n" +
                "|  2) Die Gesetze der Physik oder Logik spielen innerhalb der           |\n" +
                "|     Behörde verrückt. Räume ändern sich. Wesen werden verrückt.       |\n" +
                "!     Das einzige, was zählt: Komme durch die Räume.                    !\n" +
                ":                                                                       :\n" +
                ":  3) Es gibt ein mittelalterbegeistertes Alien, das Dinge verkauft.    :\n" +
                ".     Wer weiß, was in ihrem >Heiltrank< ist, aber er wirkt.            .\n" +
                ".     Sie hat auch >Fluchtseile<, die dich einen Raum weiter bringen.   .\n" +
                ":                                                                       :\n" +
                ":  4) Nutze die Zeit zwischen den Räumen, um dein Inventar zu sehen.    :\n" +
                "!     Rüste Waffen aus, benutze Gegenstände und bereite dich vor.       !\n" +
                "|                                                                       |\n" +
                "|  5) Wenn du stribst, musst du von Vorne beginnen.                     |\n" +
                "|                                                                       |\n" +
                "|  6) Viel Glück!                                                       |\n" +
                "|                                                                       |\n" +
                "`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'\n");

    }


    private void getActionLookaroundFromPlayer (String line){
            while (!line.equalsIgnoreCase("Ja") && !line.equalsIgnoreCase("j")
            && !line.equalsIgnoreCase("skip")){
                line = getInputStringFromPlayer(line);

                if (line.equalsIgnoreCase("Nein") || line.equalsIgnoreCase("n")) {

                    System.out.println("Du beschließt, dich nicht umzusehen, und schließt stattdessen die Augen.\n" +
                            "...so langsam wird dir langweilig.");
                    System.out.println("Willst du den Innenraum der Kapsel inspizieren?\n" +
                            "Ja[J], Nein[N] oder Hilfe[H]?");


                } else if (line.equalsIgnoreCase("Hilfe") || line.equalsIgnoreCase("H")) {
                    System.out.println(">>HIIILFE<<\n" +
                            "Dein verzweifelter Hilferuf verhallt im All. Das war wenig erfolgreich.");
                    System.out.println("Willst du den Innenraum der Kapsel inspizieren?\n" +
                            "Ja[J], Nein[N] oder Hilfe[H]?");


                } else if (!line.equalsIgnoreCase("H") && !line.equalsIgnoreCase("Hilfe")
                        && !line.equalsIgnoreCase("N") && !line.equalsIgnoreCase("Nein")
                        && !line.equalsIgnoreCase("j") && !line.equalsIgnoreCase("ja")){
                    System.out.println("Willst du den Innenraum der Kapsel inspizieren?\n" +
                            "Deine Möglichkeiten sind Ja[J], Nein[N] oder Hilfe[H].");

                }

            }
            if (line.equalsIgnoreCase("J") || line.equalsIgnoreCase("Ja")
            || line.equalsIgnoreCase("skip")){
                System.out.println("Du siehst dich um.");
                return;


            }
        }

    private void getActionButtonpressFromPlayer(String line) {
        line = getInputStringFromPlayer(line);
        while (!line.equalsIgnoreCase("H") && !line.equalsIgnoreCase("Nach hause")
                && !line.equalsIgnoreCase("skip")) {
            if (line.equalsIgnoreCase("D") || line.equalsIgnoreCase("Auto Destroy")) {
                Output.slow("Plötzlich taucht ein Auto vor dir auf und explodiert in einem Feuerball.");
                System.out.println("\n" +
                        "                      ____\n" +
                        "                     __,-~~/~    `---.\n" +
                        "                   _/_,---(      ,    )\n" +
                        "               __ /        <    /   )  \\___\n" +
                        "- ------===;;;'====------------------===;;;===----- -  -\n" +
                        "                  \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/\n" +
                        "                  (_ (   \\  (     >    \\)\n" +
                        "                   \\_( _ <         >_>'\n" +
                        "                      ~ `-i' ::>|--\"\n" +
                        "                          I;|.|.|\n" +
                        "                         <|i::|i|`.\n" +
                        "                        (` ^'\"`-' \")\n" +
                        "(was hast du erwartet?)\n" +
                        "Jetzt bleibt dir nichts anderes übrig, als den anderen Knopf zu drücken.");
                return;

            } else if (!line.equalsIgnoreCase("H") && !line.equalsIgnoreCase("nach hause")
                    && !line.equalsIgnoreCase("d") && !line.equalsIgnoreCase("auto destroy")
                    && !line.equalsIgnoreCase("h") && !line.equalsIgnoreCase("nach hause")) {
                System.out.println("Es gibt keine anderen Knöpfe\n" +
                        "Deine Möglichkeiten sind Auto Destroy[D] und Nach Hause[H]");
            }

        }
        if (line.equalsIgnoreCase("H") || line.equalsIgnoreCase("Nach hause")
                || line.equalsIgnoreCase("skip")) {
            System.out.println("Natürlich drückst du auf diesen Knopf, du bist ja nicht dumm.");
            return;
        }
    }

    private void getActionExplanationchoiceFromPlayer(String line){


        while (!line.equalsIgnoreCase("W") && !line.equalsIgnoreCase("Weg")
                && !line.equalsIgnoreCase("skip")) {
            line = getInputStringFromPlayer(line);

            if (line.equalsIgnoreCase("K") || line.equalsIgnoreCase("Kurze zusammenfassung")){
                System.out.println(".________________________________________________.\n" +
                        "|\tKURZE ZUSAMMENFASSUNG: Hol 1 Passierschein.  |\n" +
                        "'------------------------------------------------'\t\t\n" +
                        "\t\t");
                System.out.println("\t\t _________________________________________________________________________\n" +
                        "\t\t| PASSIERSCHEIN: ERKLÄRUNG[E] ZUSAMMENFASSUNG[Z] KURZE ZUSAMMENFASSUNG[K] |\n" +
                        "\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|\t\t\t\t\tWEG ZUM galVerFaGre [W]\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|_________________________________________________________________________|\n");

            }
            else if (line.equalsIgnoreCase("Z")||line.equalsIgnoreCase("Zusammenfassung")){
                System.out.println(".__________________________________________________________________________________________________________.\n" +
                        "|\tZUSAMMENFASSUNG: Ein Passierschein muss von der zuständigen galaktischen Behörde (das galaktische      | \n" +
                        "|\t Verwaltungsfachgremium, galVerFaGre) abgeholt werden, bevor die Heimholung initialisiert werden kann. |\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n" +
                        "'----------------------------------------------------------------------------------------------------_-----'\n");
                System.out.println("\t\t _________________________________________________________________________\n" +
                        "\t\t| PASSIERSCHEIN: ERKLÄRUNG[E] ZUSAMMENFASSUNG[Z] KURZE ZUSAMMENFASSUNG[K] |\n" +
                        "\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|\t\t\t\t\tWEG ZUM galVerFaGre [W]\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|_________________________________________________________________________|\n");



            }
            else if(line.equalsIgnoreCase("E") || line.equalsIgnoreCase("Erklärung")){
                System.out.println("._______________________________________________________________________________________.\n" +
                        "|\tERKLÄRUNG: Laut Verordnung zur Heimführung führungsloser Raumkapseln, \t\t\t\t|\n" +
                        "|\tgetroffen vom zuständigen galaktischen Verwaltungsgericht (mit\t\t\t\t\t\t|\n" +
                        "|\tSitz am dritten Stern von links, Verwaltungsfachstraße 1-126, \t\t\t\t\t\t|\n" +
                        "|\tz.Hdn. Herrn Dr. Dr. Prof. med. Dr. mult. Königsberger-Schachtener) bedürfen \n" +
                        "|\tHeimführungsgesuche von Raumkapseln, insbesondere solche welche unter Abs. 3 \t\t|\n" +
                        "|\tSatz 4 als >führungslos< im Sinne des FüRKG definiert werden und somit\n" +
                        "|\t1) ohne lebende Personen angetroffen wird oder sich ausweist;\t\t\t\t\t\t|\n" +
                        "|\t2) mit lebenden Personen angetroffen wird oder sich ausweist, die\n" +
                        "|\tjedoch die Definition des >Intellegenten Lebens< nach DIN 298352S\t\t\t\t\t|\n" +
                        "|\tnicht erfüllen (wie es hier der Fall zu sein scheint);\n" +
                        "|\t3) mit lebenden Personen angetroffen wird oder sich ausweist, \t\t\t\t\t\t|\n" +
                        "|\tdie die Definition des >Intellegenten Lebens< nach DIN 298352S\n" +
                        "|\terfüllen, jedoch die fristgerechte Abgabe des Antrags auf Anerkennung\t\t\t\t|\n" +
                        "|\tder Einschätzung als >Intellegentes Leben< unterlassen haben;\n" +
                        "|\tdamit als so definierte führungslose Raumkapsel bis auf Weiteres \t\t\t\t\t|\n" +
                        "|\tunter die Rechtsprechung des Gremiums für durch Idioten verursachte \n" +
                        "|\tRaumgefahren und -belange (GredIverRGuB) im Verwaltungsgericht der \t\t\t\t\t|\n" +
                        "|\tgalaktischen Föderation fallen, unabhängig der genauen Zuständigkeits-\n" +
                        "|\tbereiche der verschiedenen ausführenden Organe der zivilen Ordnung \t\t\t\t\t|\n" +
                        "|\t(Raumfeuerwacht, Raumerdwacht, Raumwasserwacht, Raumluftwacht, \n" +
                        "|\tOrdnungsamt, Grenzkontrollen der schwarzen Löcher, Raumkriminalamt, \t\t\t\t|\n" +
                        "|\tZollamt, Allgemeine Zensurbehörde, Kuscheltierpolizei) oder deren Meldepflicht, \n" +
                        "|\teiner gesonderten Prüfung dieses Heimführungsgesuches durch die \t\t\t\t\t|\n" +
                        "|\tzuständigen Organe der galaktischen Verwaltungsbehörden, wobei\n" +
                        "|\t1) gesondert festgestellt werden muss, ob die führungslose Raumkapsel\t\t\t\t|\n" +
                        "|\ta) einen Heimatplaneten hat, der durch den fristgerecht und in \n" +
                        "|   Schriftform (bevorzugt Fax) abgegebenen Antrag auf zweifelsfreie\t\t\t\t\t|\n" +
                        "|   Eintragung eines Heimatplaneten nach in das in Abs. 12 Satz 8 des\t\t\t\t\t\n" +
                        "|   RFMHRegG geführten Raumfortbewegungsmittelheimatplanetenregister \t\t\t\t\t|\n" +
                        "|   (Anlage A3) der zuständigen galaktischen Zulassungsstelle vorliegt;\n" +
                        "|   b) in ihrem Umfang, insbesondere der Materialien der Hülle sowie\t\t\t\t\t|\n" +
                        "|   der technischen Ausstattung, als geeignet für die Heimführung aus\n" +
                        "|   eigener Kraft erachtet werden kann. Für eine solche Einschätzung\t\t\t\t\t|\n" +
                        "|   ist ein Gutachter zu bestellen, welcher nach DIN 389984D3 als \n" +
                        "|   Gutachter der galaktischen Raumfortbewegungsmittelkontrolle \t\t\t\t\t\t|\n" +
                        "|   zertifiziert ist. Die Konsten dafür hat der Antragssteller \n" +
                        "|   zu tragen, wobei etwaige Mahngebühren zu beachten sind.\t\t\t\t\t\t\t\t|\n" +
                        "|\t2) der der führungslosen Raumkapsel zugeordnete eindeutige Erkennungscode\n" +
                        "|   nach §158 Abs. 78 Satz 1a-f) RaFZPolDiErCG sowohl polizeidienstlich\t\t\t\t\t|\n" +
                        "|   eingetragen sein muss als auch nach Stand der Datenbanken \n" +
                        "|   a) eindeutig nachweisbar sein muss, dass der oder die Halter des \t\t\t\t\t|\n" +
                        "|   Raumfahrzeugs alle schuldigen Gebühren zur Benutzung der \n" +
                        "|   galaktischen Fortbewegungswege (RFZ-Maut, LKRFZ-Maut,\t\t\t\t\t\t\t\t|\n" +
                        "|   LAEFGJKDFZ-Maut, Verkehrsunfallabgaben, Kraftstoffsonder-\n" +
                        "|   steuer) jederzeit ohne schuldhaftes Zögern beglichen hat;\t\t\t\t\t\t\t|\n" +
                        "|   b) kein Verweis auf eine nach $239 RaVO als besonders\n" +
                        "|   fahrlässige Verletzung der Raumverkehrsordnung oder der guten\t\t\t\t\t\t|\n" +
                        "|   Sitten definierte galaktische Ordnungswidrigkeit vorliegen darf.\n" +
                        "|\tEine solche behördliche Prüfung des Heimführungsgesuches muss\t\t\t\t\t\t|\n" +
                        "|\tdurch den vom galVerFaGre bestellten Sachbearbeiter des betreffenden\n" +
                        "|\tRaumquadranten unter Zuziehung des für den ausgewiesenen Heimatplaneten\t\t\t\t|\n" +
                        "|\tzuständigen örtlichen Gremiums zur Raumfortbewegungsmittelheimführung\n" +
                        "|\tstattfinden, wobei die Bearbeitungszeit im Ermessensspielraum des\t\t\t\t\t|\n" +
                        "|\toben genannten Gremiums liegt, 12 galaktische Zeitjahre aber nicht\n" +
                        "|\tüberschreiten darf. Im Falle der unsachgemäßen Einreichung des\t\t\t\t\t\t|\n" +
                        "|\tAntrags erlischt der Anspruch auf Heimführung, ebenso wie \n" +
                        "|\tim Falle einer Beamtenbeleidigung, einer an Bord festgestellten \t\t\t\t\t|\n" +
                        "|\tUngereimtheit mit den Antratsunterlagen oder im Falle des vorzeitigen\t\t\t\t\n" +
                        "|\tVersterbens des Antragsstellers. In letzterem Falle sind dem Antragssteller\t\t\t|\t\n" +
                        "|\tsowohl die Kosten für die Beantragung und Beendigung des Verfahrens \t\t\t\t\n" +
                        "|\tals auch die Kosten für die Feststellung der Beendigung des \t\t\t\t\t\t|\n" +
                        "|\tLebenszustandes in Rechnung zu stellen.\t\t\t\t\t\t\t\t\t\t\t\t|\n" +
                        "'---------------------------------------------------------------------------------------' \n" +
                        " ");

                System.out.println("\t\t _________________________________________________________________________\n" +
                        "\t\t| PASSIERSCHEIN: ERKLÄRUNG[E] ZUSAMMENFASSUNG[Z] KURZE ZUSAMMENFASSUNG[K] |\n" +
                        "\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|\t\t\t\t\tWEG ZUM galVerFaGre [W]\t\t\t\t\t\t\t\t  |\n" +
                        "\t\t|_________________________________________________________________________|\n");


            }
         else if (!line.equalsIgnoreCase("e") && !line.equalsIgnoreCase("erklärung")
                && !line.equalsIgnoreCase("z") && !line.equalsIgnoreCase("zusammenfassung")
                    && !line.equalsIgnoreCase("k") && !line.equalsIgnoreCase("kurze zusammenfassung")
                    && !line.equalsIgnoreCase("w") && !line.equalsIgnoreCase("weg")) {
            System.out.println("Den Knopf gibt es nicht...");
        }

    }
        if (line.equalsIgnoreCase("W") || line.equalsIgnoreCase("Weg")
                || line.equalsIgnoreCase("skip")) {
        System.out.println("Die Raumkapsel beept bestätigend und setzt sich in Bewegung.");
        return;


        }




    }


    private String getInputStringFromPlayer (String line){
        try {
            line = "";
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}



