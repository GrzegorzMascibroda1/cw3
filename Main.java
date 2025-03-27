public class Main {
    public static void main(String[] args) {
        SklepKomputerowy sklep = new SklepKomputerowy();

        //produkty
        Produkt produkt1 = new Produkt();
        produkt1.setId(1);
        produkt1.setNazwa("Laptop Dell 13 Ultra");
        produkt1.setKategoria("Laptop");
        produkt1.setCena(4999.99);
        produkt1.setIloscWMagazynie(10);

        Produkt produkt2 = new Produkt();
        produkt2.setId(2);
        produkt2.setNazwa("Mysz LogitechPro3");
        produkt2.setKategoria("Mysz");
        produkt2.setCena(349.99);
        produkt2.setIloscWMagazynie(30);

        sklep.dodajProdukt(produkt1);
        sklep.dodajProdukt(produkt2);

        //klienci
        Klient klient1 = new Klient();
        klient1.setId(1);
        klient1.setImie("Jan");
        klient1.setNazwisko("Kowalski");
        klient1.setEmail("jan.kowalski@example.com");
        klient1.setCzyStaly(true);

        Klient klient2 = new Klient();
        klient2.setId(2);
        klient2.setImie("Anna");
        klient2.setNazwisko("Nowak");
        klient2.setEmail("anna.nowak@example.com");
        klient2.setCzyStaly(false);

        sklep.dodajKlienta(klient1);
        sklep.dodajKlienta(klient2);

        //zamówienia
        Produkt[] produktZamowienia1 = {produkt1, produkt2};
        int[] ilosciZamowienia1 = {1, 1};
        Zamowienie zamowienie1 = sklep.utworzZamowienie(klient1, produktZamowienia1, ilosciZamowienia1);
        zamowienie1.zastosujZnizke();
        sklep.aktualizujStanMagazynowy(zamowienie1);

        Produkt[] produktZamowienia2 = {produkt1, produkt2};
        int[] ilosciZamowienia2 = {2, 1};
        Zamowienie zamowienie2 = sklep.utworzZamowienie(klient2, produktZamowienia2, ilosciZamowienia2);
        sklep.aktualizujStanMagazynowy(zamowienie2);

        //stan magazynu
        System.out.println("\nStan magazynowy po zamówieniu:");
        sklep.wyswietlProduktyWKategorii("Laptop");
        sklep.wyswietlProduktyWKategorii("Mysz");

        //status zamówienia
        sklep.zmienStatusZamowienia(zamowienie1.getId(), "Zrealizowane");
        System.out.println("\nStatus zamówienia po aktualizacji:");
        zamowienie1.wyswietlSzczegoly();

        //wyświetlanie zamówień
        System.out.println("\nZamówienia klienta Jan Kowalski:");
        sklep.wyswietlZamowieniaKlienta(1);
    }
}