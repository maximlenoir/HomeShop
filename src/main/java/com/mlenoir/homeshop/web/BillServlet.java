package com.mlenoir.homeshop.web;

import com.mlenoir.homeshop.Fridge;
import com.mlenoir.homeshop.Product;
import com.mlenoir.homeshop.Television;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillServlet extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Product philipsSenseo = new Product("Philips HD7866/61", "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", 79.99d);
        Product samsungTv = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"", 599d, 49, "LED");
        Fridge bekoFridge = new Fridge("BEKO TSE 1042 F", "Réfrigérateur BEKO 130L - Classe A+ - Blanc", 189d, 130, false);

        this.products.add(philipsSenseo);
        this.products.add(samsungTv);
        this.products.add(bekoFridge);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        if (req.getQueryString() == null) {
            this.displayForm(resp);
        } else {
            //this.displayBill(req, resp);
        }
    }

    private void displayForm(HttpServletResponse resp) throws IOException {
        for (int i = 0; i < this.products.size(); i++) {
            Product product = products.get(i);

            resp.getWriter().println(
                "<b>" + i + " - " + product.getName() + "</b> : " + product.getPrice() + "€<br />" + product.getDescription() + "<br /><br />"
            );
        }

        String form = "<form action=\"bill\">" +
            "<b>Nom complet :</b> <input name=\"fullName\" /><br />" +
            "<b>Adresse :</b> <input name=\"address\" /><br />" +
            "<b>Mode de livraison :</b><br />" +
            "Livraison à domicile : <input type=\"radio\" name=\"deliveryMode\" value=\"direct\" /><br />" +
            "Livraison à domicile express 24h : <input type=\"radio\" name=\"deliveryMode\" value=\"express\" /><br />" +
            "Livraison en point relais : <input type=\"radio\" name=\"deliveryMode\" value=\"relay\" /><br />" +
            "Retrait gratuit à l'entrepôt dans Paris : <input type=\"radio\" name=\"deliveryMode\" value=\"takeAway\" /><br />" +
            "<br />" +
            "<b>Informations de livraison</b> (point relais et express) : <input name=\"deliveryInfo\" /><br /><br />" +
            "<b>Liste des produits </b> (format produit:quantité, avec un produit par ligne) :<br />" +
            "<textarea name=\"products\"></textarea><br />" +
            "<input type=\"submit\" />" +
            "</form>"
        ;

        resp.getWriter().println(form);
    }
}
