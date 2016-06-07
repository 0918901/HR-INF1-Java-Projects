package Opdracht1;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class DB_Ticketbestelsysteem {

    public static void main (String []args) {
        boolean Keuze_abonnementhouder;

        int true_abonnementhouder;
        int true_kinderen;
        int true_peuters;
        int true_begeleiders;
        int true_controle;

        int abonnementhouder = 0;
        int volwassene;
        int kinderen = 0;
        int peuters = 0;
        int begeleiders = 0;
        int groep;

        double prijs_volwassene = 20.00f;
        double prijs_kinderen = 15.50f;
        double prijs_begeleiders = 12.00f;

        Scanner user_input = new Scanner(System.in);

        for (int x = 0; x <= 100; x++) {
            System.out.println("=========================================================================================");
            System.out.println("Welkom bij het ticketbestelsysteem van Diergaarde Blijdorp");
            System.out.println("=========================================================================================");
            System.out.println("Uw bestelling?");
            System.out.println("=========================================================================================");

            System.out.println("Heeft u al een abonnemenent?");
            System.out.println("1 = JA");
            System.out.println("2 = NEE");
            System.out.println("Na uw keuze druk op ENTER");
            System.out.print("Keuze:\t");

            true_abonnementhouder = user_input.nextInt();

            System.out.println("=========================================================================================");

            if (true_abonnementhouder == 1) {
                Keuze_abonnementhouder = true;
                System.out.print("Aantal abonnementhouders: \t");
                abonnementhouder = user_input.nextInt();
            } else {
                Keuze_abonnementhouder = false;
                System.out.println("Geen abonnnementhouders");
            }

            System.out.println("=========================================================================================");


            System.out.println("Volwassene = 13+ jaar");
            System.out.print("Aantal volwassene: \t");
            volwassene = user_input.nextInt();

            System.out.println("=========================================================================================");


            if (volwassene <= 4 && Keuze_abonnementhouder) {
                prijs_volwassene = 15.00f;
                System.out.println("25% Korting bij Max 4 introductés");
                System.out.println("Huidige prijs : \t€\t" + prijs_volwassene + "\tp.p");
                System.out.println("Uw korting: \t\t€\t5,00 X " + volwassene + " = €\t" + (volwassene * 5.00));
                prijs_volwassene = volwassene * prijs_volwassene;
            }

            if (volwassene > 4 && Keuze_abonnementhouder) {
                prijs_volwassene = 20.00f;
                prijs_volwassene = volwassene * prijs_volwassene;
                System.out.println("25% Korting bij Max 4 introductés");
                System.out.println("Huidige prijs: \t\t€\t20,00 X " + volwassene + " = €\t" + (volwassene * 20.00));
                System.out.println("Uw korting: \t\t€\t20.00");
                prijs_volwassene = (prijs_volwassene - 20.00);
            }

            if (volwassene > 4 && !Keuze_abonnementhouder) {
                prijs_volwassene = 20.00f;
                prijs_volwassene = volwassene * prijs_volwassene;
                System.out.println("Huidige prijs: 	\t€\t20,00 X " + volwassene + " = €\t" + (volwassene * 20.00) + " p.p");
            }

            if (volwassene <= 4 && !Keuze_abonnementhouder) {
                prijs_volwassene = 20.00f;
                prijs_volwassene = volwassene * prijs_volwassene;
                System.out.println("Huidige prijs: 	\t€\t20,00 X " + volwassene + " = €\t" + (volwassene * 20.00) + " p.p");
            }

            volwassene = volwassene + abonnementhouder;
            System.out.println("Nieuwe totale prijs:€\t" + prijs_volwassene);

            System.out.println("=========================================================================================");

            System.out.println("Neemt u ook kinderen mee?");
            System.out.println("Kinderen = 3 t/m 12 jaar");
            System.out.println("1 = JA");
            System.out.println("2 = NEE");
            System.out.println("Na uw keuze druk op ENTER");
            System.out.print("Keuze:\t");
            true_kinderen = user_input.nextInt();

            System.out.println("=========================================================================================");

            if (true_kinderen == 1) {
                System.out.print("Aantal kinderen: \t");
                kinderen = user_input.nextInt();

                System.out.println("=========================================================================================");

                prijs_kinderen = kinderen * prijs_kinderen;
                System.out.println("Huidige prijs: 	\t€\t15,50 X " + kinderen + " = €\t" + (kinderen * 15.50));
                System.out.println("Total prijs: \t\t€\t" + (prijs_volwassene + prijs_kinderen));

            } else {
                prijs_kinderen = 0.00;
                System.out.println("Geen kinderen");
            }

            System.out.println("=========================================================================================");


            System.out.println("Neemt u ook peuters mee?");
            System.out.println("Peuters = 0 t/m 2 jaar");
            System.out.println("1 = JA");
            System.out.println("2 = NEE");
            System.out.println("Na uw keuze druk op ENTER");
            System.out.print("Keuze:\t");
            true_peuters = user_input.nextInt();

            System.out.println("=========================================================================================");


            if (true_peuters == 1) {
                System.out.print("Aantal peuters: \t");
                peuters = user_input.nextInt();
                System.out.println("Peuters zijn gratis");

            } else {
                System.out.println("Geen peuters");
            }

            System.out.println("=========================================================================================");


            System.out.println("Zijn ook begeleiders voor gehandicapte personen mee?");
            System.out.println("1 = JA");
            System.out.println("2 = NEE");
            System.out.println("Na uw keuze druk op ENTER");
            System.out.print("Keuze:\t");
            true_begeleiders = user_input.nextInt();

            System.out.println("=========================================================================================");


            if (true_begeleiders == 1) {
                System.out.print("Aantal begeleiders: \t");
                begeleiders = user_input.nextInt();
                prijs_begeleiders = begeleiders * prijs_begeleiders;

                System.out.println("Huidige prijs: 	\t€\t12,00 X " + begeleiders + " = €\t" + (kinderen * 12.00));
                System.out.println("Total prijs: \t\t€\t" + (prijs_volwassene + prijs_kinderen));

                System.out.println("=========================================================================================");


                System.out.println("Total prijs: €\t" + (prijs_volwassene + prijs_kinderen + prijs_begeleiders));
            } else {
                prijs_begeleiders = 0.00;
                System.out.println("Geen begeleiders");
            }


            groep = (kinderen + volwassene);

            if (groep >= 20) {
                System.out.println("=========================================================================================");
                System.out.println("Groepskorting!!");
                prijs_volwassene = 18.00f;
                prijs_kinderen = 13.50f;
                prijs_volwassene = volwassene * prijs_volwassene;
                prijs_kinderen = kinderen * prijs_kinderen;
                System.out.println("Uw korting: \t€\t 20.00 X " + volwassene + " = \t€\t" + (volwassene * 20.00) + "\tp.p");
                System.out.println("\t\t\t\t€\t 15.50 X " + kinderen + " = \t€\t" + (kinderen * 15.50) + "\tp.p");
                System.out.println("Huidige prijs: \t€\t" + ((kinderen * 15.50) + (volwassene * 20.00)));

                System.out.println("=========================================================================================");

                System.out.println("€2,- Korting vanaf 20 personen");
                System.out.println("Uw korting: \t€\t 18.00 X " + volwassene + " = \t€\t" + (volwassene * 18.00) + "\tp.p");
                System.out.println("\t\t\t\t€\t 13.50 X " + kinderen + " = \t€\t" + (kinderen * 13.50) + "\tp.p");
                System.out.println("Nieuwe prijs: \t€\t" + (prijs_kinderen + prijs_volwassene));
            }

            double prijs_totaal = (prijs_volwassene + prijs_kinderen + prijs_begeleiders);

            System.out.println("=========================================================================================");

            System.out.println("Aantal abonnementhouders: \t" + abonnementhouder);
            System.out.println("Aantal volwassene: \t\t\t" + volwassene + "\tX €20.00 \t = " + prijs_volwassene);
            System.out.println("Aantal kinderen: \t\t\t" + kinderen + "\tX €15.50 \t = " + prijs_kinderen);
            System.out.println("Aantal peuters: \t\t\t" + peuters + "\t Peuters zijn gratis");
            System.out.println("Aantal begeleiders: \t\t" + begeleiders + "\tX €12.00 \t = " + prijs_begeleiders);
            if (groep >= 20) {
                System.out.println("=========================================================================================");
                System.out.println("Groepskorting: \t€\t" + (((kinderen * 13.50) + (volwassene * 18.00)) - ((kinderen * 15.50) + (volwassene * 20.00))));
            }
            System.out.println("=========================================================================================");
            System.out.println("Totaal prijs = \t€\t" + prijs_totaal);
            System.out.println("=========================================================================================");

            System.out.println("is uw bestelling correct?");
            System.out.println("1 = JA");
            System.out.println("2 = NEE");
            System.out.println("Na uw keuze druk op ENTER");
            System.out.print("Keuze:\t");
            true_controle = user_input.nextInt();
            if (true_controle == 1) {
                System.out.println("Dank u wel voor uw bestelling");
            } else {
                continue;
            }
            System.out.println("=========================================================================================");

        }
    }
}
