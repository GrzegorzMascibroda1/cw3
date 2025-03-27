import java.util.ArrayList;

public class SklepKomputerowy {
    private ArrayList<Produkt> produkty = new ArrayList<>();
    private ArrayList<Klient> klienci = new ArrayList<>();
    private ArrayList<Zamowienie> zamowienia = new ArrayList<>();

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setId(zamowienia.size() + 1);
        zamowienie.setKlient(klient);
        zamowienie.setProdukty(produkty);
        zamowienie.setIlosci(ilosci);
        zamowienia.add(zamowienie);
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (int i = 0; i < zamowienie.getProdukty().length; i++) {
            Produkt produkt = zamowienie.getProdukty()[i];
            int ilosc = zamowienie.getIlosci()[i];
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie() - ilosc);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie zamowienie : zamowienia) {
            if (zamowienie.getId() == idZamowienia) {
                zamowienie.setStatus(nowyStatus);
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        for (Produkt produkt : produkty) {
            if (produkt.getKategoria().equalsIgnoreCase(kategoria)) {
                produkt.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (Zamowienie zamowienie : zamowienia) { // Zmieniono nazwę zmiennej lokalnej na 'zamowienie'
            if (zamowienie.getKlient().getId() == idKlienta) {
                zamowienie.wyswietlSzczegoly();
            }
        }
    }
}