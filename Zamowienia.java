public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double obliczWartoscZamowienia() {
        double wartosc = 0;
        for (int i = 0; i < produkty.length; i++) {
            wartosc += produkty[i].getCena() * ilosci[i];
        }
        return wartosc;
    }

    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            System.out.println("Zniżka 10% zastosowana.");
        }
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id + ", Data: " + dataZamowienia +
                ", Status: " + status + ", Klient: " + klient.getImie() + " " + klient.getNazwisko());
    }
}