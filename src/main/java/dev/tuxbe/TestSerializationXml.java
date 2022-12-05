package dev.tuxbe;

import dev.tuxbe.enums.TypeCompte;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.Date;

public class TestSerializationXml {
    public static void main(String[] Args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Banque.class);
        Compte c1 = new Compte(1, 4500, new Date(), TypeCompte.COURANT);
        Compte c2 = new Compte(2, 78000, new Date(), TypeCompte.EPARGNE);
        Compte c3 = new Compte(3, 147000, new Date(), TypeCompte.COURANT);

        Banque banque = new Banque();
        banque.comptes.add(c1);
        banque.comptes.add(c2);
        banque.comptes.add(c3);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Permet de formatter la sortie
        marshaller.marshal(banque, new File("comptes.xml"));

    }
}
