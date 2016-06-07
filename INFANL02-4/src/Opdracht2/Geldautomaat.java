package Opdracht2;

import java.util.Scanner;

class Geldautomaat{

    public static void main (String []args) {
        int pashouderinvoer;
        Scanner user_input = new Scanner(System.in);
        Betaalsysteem HRO = new Betaalsysteem();

        HRO.Welkom();
        HRO.startKeuzeMenu();
        pashouderinvoer = user_input.nextInt();
        HRO.startKeuzeMenuANS(pashouderinvoer);

        for(int x = 0; x<100; x++) {
            HRO.geldKeuzeMenu();
            pashouderinvoer = user_input.nextInt();
            if (pashouderinvoer == 1 ||
                    pashouderinvoer == 2 ||
                    pashouderinvoer == 3 ||
                    pashouderinvoer == 4 ||
                    pashouderinvoer == 5){
                HRO.geldKeuzeMenuANS(pashouderinvoer);
            }
            if (pashouderinvoer == 6) {
                HRO.accountKeuzeMenu();
                pashouderinvoer = user_input.nextInt();
                HRO.accountKeuzeMenuANS(pashouderinvoer);
            }else {
                System.out.println("ongeldige invoer probeer opnieuw");
            }
        }
    }
}

class Account{
    private String naampashouder = "testaccount";
    private int nummerpashouder = 123;
    private int pincode = 1234;
    int saldo = 100;
    int kredietlimiet = -500;

    Account(){

    }

    public Account(String naampashouder, int nummerpashouder, int pincode, int saldo, int kredietlimiet) {
        this.naampashouder = naampashouder;
        this.nummerpashouder = nummerpashouder;
        this.pincode = pincode;
        this.saldo = saldo;
        this.kredietlimiet = kredietlimiet;
    }

    String getNaampashouder() {
        System.out.println("Naam:\t\t\t"+ naampashouder);
        return naampashouder;
    }

    void setNaampashouder(String naampashouder) {
        this.naampashouder = naampashouder;
    }

    int getNummerpashouder() {
        System.out.println("Pasnummer:\t\t"+nummerpashouder);
        return nummerpashouder;
    }

    void setNummerpashouder(int nummerpashouder) {
        this.nummerpashouder = nummerpashouder;
    }

    int getPincode() {
        System.out.println("Pincode:\t\t"+pincode);
        return pincode;
    }

    void setPincode(int pincode) {
        this.pincode = pincode;
    }

    int getSaldo() {
        System.out.println("Saldo:\t\t\t€ "+saldo+",-");
        return saldo;
    }

    void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    int getKredietlimiet() {
        System.out.println("Kreditlimiet:\t€ "+kredietlimiet+",-");
        return kredietlimiet;
    }

    void setKredietlimiet(int kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }
}

@SuppressWarnings("ALL")
class Betaalsysteem extends Account{

    private int opnamelimiet = 5000;
    private int pashouderinvoer_int;
    private String pashouderinvoer_string;
    private final Scanner user_input = new Scanner(System.in);

    public Betaalsysteem(){

    }

    public Betaalsysteem(int opnamelimiet){
        this.opnamelimiet = opnamelimiet;
    }


    public void Welkom(){
        System.out.println("Welkom bij HRO geldautomaat");
        System.out.println("----------------------------------------------------------------");
    }
    public void startKeuzeMenu(){
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil een testaccount gebruiken");
        System.out.println("2 = Nieuwe account maken");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");

    }

    public void startKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer == 1){
            bestaandAccount();
        }else{
            nieuwAccount();
        }
    }

    public void geldKeuzeMenu(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil pinnnen");
        System.out.println("2 = Ik wil storten");
        System.out.println("3 = Wat is mijn saldo?");
        System.out.println("4 = Wat is mijn kredietlimiet?");
        System.out.println("5 = Ik wil mijn gegevens weergeven");
        System.out.println("6 = Ik wil mijn gegevens wijzigen");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");
    }

    public void geldKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer > 6 || pashouderinvoer < 0) {
            System.out.println("onjuiste invoer");
            geldKeuzeMenu();
            pashouderinvoer = user_input.nextInt();
        }
        if (pashouderinvoer == 1) {
            System.out.println("Hoeveel wilt u pinnen?:");
            pashouderinvoer = user_input.nextInt();
            geldPinnen(pashouderinvoer);
            getSaldo();
        }
        if (pashouderinvoer == 2) {
            System.out.println("Hoeveel wilt u storten?:");            pashouderinvoer = user_input.nextInt();
            geldStoren(pashouderinvoer);
            System.out.println("Storten is gelukt");
            getSaldo();
        }
        if (pashouderinvoer == 3) {
            getSaldo();
        }
        if (pashouderinvoer == 4) {
            getKredietlimiet();
        }
        if (pashouderinvoer == 5) {
            controleAccount();
        }
    }

    public void accountKeuzeMenu(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil mijn naam wijzigen");
        System.out.println("2 = Ik wil mijn saldo wijzigen");
        System.out.println("3 = Ik wil mijn kredit wijzigen");
        System.out.println("4 = Ik wil mijn opnamelimiet wijzigen");
        System.out.println("5 = Ik wil mijn pincode wijzigen");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");
    }



    public void accountKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer == 1){
            getNaampashouder();
            System.out.println("Wijzig uw naam in:");
            pashouderinvoer_string = user_input.nextLine();
            setNaampashouder(pashouderinvoer_string);
            getNaampashouder();
        }
        if (pashouderinvoer == 2){
            getSaldo();
            System.out.println("Wijzig uw saldo in:");
            pashouderinvoer = user_input.nextInt();
            setSaldo(pashouderinvoer);
            getSaldo();
        }
        if (pashouderinvoer == 3){
            getKredietlimiet();
            System.out.println("Wijzig uw kreditlimiet in:");
            pashouderinvoer = user_input.nextInt();
            if (pashouderinvoer < 0){
                setKredietlimiet(pashouderinvoer);
            }else {
                setKredietlimiet(-pashouderinvoer);
            }
            getKredietlimiet();
        }
        if (pashouderinvoer == 4){
            getOpnamelimiet();
            System.out.println("Wijzig de opnamelimiet in:");
            pashouderinvoer = user_input.nextInt();
            setOpnamelimiet(pashouderinvoer);
            getOpnamelimiet();
        }
        if (pashouderinvoer == 5){
            getPincode();
            System.out.println("Wijzig uw pincode in:");
            pashouderinvoer = user_input.nextInt();
            setPincode(pashouderinvoer);
            getPincode();
        }
    }

    private void bestaandAccount(){
        System.out.println("----------------------------------------------------------------");
        getNaampashouder();
        getNummerpashouder();
        getPincode();
        getSaldo();
        getKredietlimiet();
        getOpnamelimiet();
    }

    private void nieuwAccount(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Vul een naam in:");
        pashouderinvoer_string = user_input.nextLine();
        setNaampashouder(pashouderinvoer_string);

        System.out.println("Wat wordt uw nieuwe pincode? (Max.4 getallen):");
        pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 9999){
            setPincode(pashouderinvoer_int);
        }else {
            System.out.println("[FOUT] Probeer opnieuw (Max. 4 getallen)!!");
            pashouderinvoer_int = user_input.nextInt();
            setPincode(pashouderinvoer_int);
        }

        System.out.println("Wat is uw pasnummer? (Max. 3 getallen):");
        pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 999) {
            setNummerpashouder(pashouderinvoer_int);
        }else{
            System.out.println("[FOUT] Probeer opnieuw (Max. 3 getallen)!!");
            pashouderinvoer_int = user_input.nextInt();
            setNummerpashouder(pashouderinvoer_int);
        }

        System.out.println("Stel uw nieuwe saldo in:");
        pashouderinvoer_int = user_input.nextInt();
        setSaldo(Math.abs(pashouderinvoer_int));

        System.out.println("Stel uw nieuwe kreditlimiet in:");
        pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 0){
            setKredietlimiet(pashouderinvoer_int);
        }else {
            setKredietlimiet(-pashouderinvoer_int);
        }

        System.out.println("Stel geldautomaat limiet in:");
        pashouderinvoer_int = user_input.nextInt();
        setOpnamelimiet(Math.abs(pashouderinvoer_int));

        System.out.println("----------------------------------------------------------------");
        System.out.println("Nieuwe Opdracht2.Account succesvol aangemaakt");
        controleAccount();
    }

    private void controleAccount(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Acountgegevens");
        getNaampashouder();
        getNummerpashouder();
        getPincode();
        getSaldo();
        getKredietlimiet();
        getOpnamelimiet();
    }

    private int geldStoren(int storten){
        saldo = saldo+storten;
        return saldo;
    }

    private int geldPinnen(int pinnen){
        if (pinnen < opnamelimiet){
            if (saldo >= kredietlimiet){
                saldo = saldo - pinnen;
                System.out.println("Geld opname succesvol uitgevoerd");
            }
            if (saldo < kredietlimiet){
                saldo = saldo + pinnen;
                System.out.println("onvoldoende saldo");
            }
        }else{
            System.out.println("De geldautomaat heeft \n" +
                    "onvoldoende biljetten beschibaar");
        }
        return saldo;
    }

    private int getOpnamelimiet() {
        System.out.println("Opnamelimiet:\t€ "+opnamelimiet+",-");
        return opnamelimiet;
    }

    private void setOpnamelimiet(int opnamelimiet) {

        this.opnamelimiet = opnamelimiet;
    }
}