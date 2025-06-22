package com.logicbig.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

//Sergio Wu
@WebServlet(name = "exchangeRatesServlet",
        urlPatterns = {"/exchange-rate"},
        loadOnStartup = 1)
public class ExchangeRatesServlet extends HttpServlet {
    static final String currencyPairKey = "currencyPair";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Optional<Cookie> op = Arrays.stream(req.getCookies())
                                    .filter(c -> currencyPairKey.equals(c.getName()))
                                    .findAny();
        if (op.isPresent()) {
            showCurrencyRate(req, resp, op.get().getValue());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/currencySelection.html");
            rd.forward(req, resp);
        }
    }

    // Agora o método recebe o HttpServletRequest para usar o getContextPath()
    private static void showCurrencyRate(HttpServletRequest req, HttpServletResponse resp, String currencyPair)
            throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(String.format("<p>The exchange rate for %s = %s</p>",
                currencyPair, Math.round((Math.random() + 1) * 100)));
        writer.write("<p>Select <a href='" + req.getContextPath() + "/remove-currency-pair'>Remove currency selection</a></p>");
        writer.close();
    }
}
